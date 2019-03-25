### Build and Push howdy-akka

```
cd howdy-akka
sbt assembly
cf push
```

## howdy-akka end-point(s)

Simple demo app that has end-points to create user / delete user and get all users.

Create user:  
``http --json http://<host-name>/users name=sam age:=10 countryOfResidence=USA``
``http --json http://<host-name>/users name=adit age:=9 countryOfResidence=USA``

Delete user:  
``http --json DELETE http://<host-name>/users/sam``

List of users:  
```http http://<host-name>/users``


