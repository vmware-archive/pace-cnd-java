## Build and Push howdy-proxy

```
cd howdy-proxy
mvnw clean package
```

Add the end-point(s) into manifest.yml
* Replace <howdy-boot-endpoint-here> with actual howdy-boot end-point
* Replace <howdy-kotlin-endpoint-here> with actual howdy-kotlin end-point
* Replace <howdy-akka-endpoint-here> with actual howdy-akka end-point
* Replace <howdy-nodejs-endpoint-here> with actual howdy-nodejs end-point
* Replace <howdy-python-endpoint-here> with actual howdy-python end-point

``cf push``

Record the proxy-end-point because we'll use it below to test api calls
