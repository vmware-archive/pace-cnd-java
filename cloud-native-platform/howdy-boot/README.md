## Build and Push howdy-boot

```
cd howdy-boot
mvnw clean package
cf push
```

## howdy-boot end-point(s)

Simple demo app that has end-points to generate random names

Full random name:  
``/names``

Random first name:  
``/names/first``

Random last name:  
``/names/last``
