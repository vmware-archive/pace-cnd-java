## A demo of Cloud Foundry's polyglot runtime

The purpose of this project is to front several microservices implemented in different languages running in cloud foundry.  One of the benefits of microservices is the power of choice.  If you're a java geek then use java, python...hey go for it, kotlin even better!  Use what you and your team are comfortable with.  The thing is...the more you vary the harder it becomes to operationalize but such things don't need to plague us in the 21st century.  Enter Cloud Foundry...it helps provide developer choice yet maintain operational sanity...and sanity is important.

This demo provides an API front to the following microservices:

* [howdy-akka](https://github.com/corbtastik/howdy-akka)
* [howdy-boot](https://github.com/corbtastik/howdy-boot)
* [howdy-nodejs](https://github.com/corbtastik/howdy-nodejs)
* [howdy-kotlin](https://github.com/corbtastik/howdy-kotlin)
* [howdy-python](https://github.com/corbtastik/howdy-python)

1. Clone the microservice repos above
1. If nessesary build each project (akka, boot and kotlin)
1. Login to Cloud Foundry ([Pivotal Web Services](https://run.pivotal.io/) is an excellent choice)
1. cf push each microservice (you may need to specify random-route in manifest.yml)
1. Record the end-point for each microservice
1. Clone [this repo](https://github.com/corbtastik/api-zuulproxy)
1. Add the end-point(s) into manifest.yml
1. Build ./mvnw clean package
1. cf push (you may need to specify random-route in manifest.yml)
1. test calls through the api-proxy

Test calls after everything ^^^ is cf push'd

and I recommend [HTTPie](https://httpie.org/) which is used below as 'http'

```
http howdy.cfapps.io/akka/users
http howdy.cfapps.io/springboot/names
http howdy.cfapps.io/nodejs/howdy
http howdy.cfapps.io/kotlin/address
http howdy.cfapps.io/python/int
```
