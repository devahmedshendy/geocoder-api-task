## Geocoder API Task - Overview
A JSON-based RESTful API, an end-point that will accept address as a single string and use this address parameter to query Google API, that should be consumed using XML format.
The response would contain the formatted address, as well as latitude and longitude of the address.

## Core Components
  * Spring Boot: 1.5.9.RELEASE
    * spring-boot-starter-web, spring-boot-devtools, spring-boot-starter-test
    * lombok, jackson
  * Apache Camel: 2.20.1
    * camel-spring-boot-starter, camel-geocoder-starter, camel-servlet-starter, camel-jackson-starter
  * Others:
    * dockerfile-maven-extension, dockerfile-maven-plugin: 1.3.7
    
    
## Run The Application
* **Run As Spring Boot**
```
git clone https://github.com/devahmedshendy/geocoder-api-task.git geocoder
cd geocoder
mvn spring-boot:run
```

* **Run As Docker Container**
```
git clone https://github.com/devahmedshendy/geocoder-api-task.git geocoder
cd geocoder
mvn clean package
docker run -it --rm -p 5000:5000 --name geocoder devahmedshendy/geocoder-api:0.2
```

* **Talking to the API**
```
curl http://localhost:5000/camel/geocoder?address=cairo
```

* **Clean Up**
```
mvn clean
docker image rmi devahmedshendy/geocoder-api:0.2
```
