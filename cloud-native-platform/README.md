## A demo of Cloud Foundry's polyglot runtime

The purpose of this module is to front several microservices implemented in different languages running in cloud foundry.  One of the benefits of microservices is the power of choice.  If you're a java geek then use java, python...hey go for it, kotlin even better!  Use what you and your team are comfortable with.  The thing is...the more you vary the harder it becomes to operationalize but such things don't need to plague us in the 21st century.  Enter Cloud Foundry...it helps provide developer choice yet maintain operational sanity...and sanity is important.

This demo provides an API front to the following microservices which we'll build and push to Cloud Foundry.

* howdy-akka
* howdy-boot
* howdy-kotlin
* howdy-nodejs
* howdy-python

## Requirements

* Access to a Cloud Foundry deployment, [PWS](https://run.pivotal.io) is nice or [PCF Dev](https://pivotal.io/pcf-dev)
* Download and install [cf-cli](https://pivotal.io/platform/pcf-tutorials/getting-started-with-pivotal-cloud-foundry/install-the-cf-cli)
* Download and install [HTTPie](https://httpie.org/) which is used below as 'http'


### Login to Cloud Foundry (pws shown)

* ``cf login -a api.run.pivotal.io``

## Build and Push projects

### Build and Push howdy-akka

* ``cd howdy-akka``
* ``sbt assembly``
* ``cf push``
* Record the end-point

### Build and Push howdy-boot

* ``cd howdy-boot``
* ``mvnw clean package``
* ``cf push``
* Record the end-point

### Build and Push howdy-kotlin

* ``cd howdy-kotlin``
* ``mvnw clean package``
* ``cf push``
* Record the end-point

### Build and Push howdy-nodejs

* ``cd howdy-nodejs``
* ``cf push``
* Record the end-point

### Build and Push howdy-python

* ``cd howdy-python``
* ``cf push``
* Record the end-point

### Build and Push howdy-proxy

* ``cd howdy-proxy``
* ``mvnw clean package``
* Add the end-point(s) into manifest.yml
  * Replace ``<howdy-boot-endpoint-here>`` with howdy-boot end-point you saved from above.
  * Replace ``<howdy-kotlin-endpoint-here>`` with howdy-kotlin end-point you saved from above.
  * Replace ``<howdy-akka-endpoint-here>`` with howdy-akka end-point you saved from above.  
  * Replace ``<howdy-nodejs-endpoint-here>`` with howdy-nodejs end-point you saved from above.
  * Replace ``<howdy-python-endpoint-here>`` with howdy-python end-point you saved from above.
* ``cf push``
* Record the proxy-end-point because we'll use it below to test api calls

## Test api(s)

```
http <proxy-end-point>/akka/users
http <proxy-end-point>/springboot/names
http <proxy-end-point>/nodejs/howdy
http <proxy-end-point>/kotlin/address
http <proxy-end-point>/python/int
```
