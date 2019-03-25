### Build and Push howdy-akka

```
cd howdy-akka
sbt assembly
cf push
```

* Create user ``http --json http://<host-name>/users name=sam age:=10 countryOfResidence=USA``
* Create user ``http --json http://<host-name>/users name=adit age:=9 countryOfResidence=USA``
* Delete user ``http --json DELETE http://<host-name>/users/sam``
* Get list of all users ``http http://<host-name>/users``


