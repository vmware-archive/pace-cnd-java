## Build and Push howdy-kotlin

```
cd howdy-kotlin
mvnw clean package
cf push
```

## howdy-kotlin end-point(s)

A simple Kotlin Spring Boot demo that generates random addresses

Random Full Address:
``/address``

Random Street Name:  
``/address/street``

Random City:  
``/address/city``

Random State:  
``/address/state``

Random Zipcode:  
``/address/zipcode``
