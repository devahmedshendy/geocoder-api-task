## Geocoding Task - Overview
A JSON-based RESTful API, an end-point that will accept address as a single string and use this address parameter to query Google API, that should be consumed using XML format.
The response would contain the formatted address, as well as latitude and longitude of the address.

## Core Components
  * Spring Boot: 2.0.0.M7.RELEASE
    * spring-boot-starter-web, spring-boot-devtools, spring-boot-starter-test, lombok, jackson
  * Others:
    * dockerfile-maven-extension, dockerfile-maven-plugin: 1.3.7
    * google-maps-services: 0.2.5
    
    
## Run The Application
* **Set API Key**: 
  * If you don't have one please get one from here: [get-api-key](https://developers.google.com/maps/documentation/geocoding/get-api-key)
  * Set the key `google.geocoding-api.key` in `application.properites` file.

* **Run As Spring Boot**
```
git clone https://github.com/devahmedshendy/geocoding-task.git
cd geocoding-task
mvn spring-boot:run
```

* **Run As Docker Container**
```
cd geocoding-task
docker build -t geocoding-image .
docker run -it --rm -p 5000:5000 --name geocoding geocoding-image:0.1
```

* **Talking to the API**
  * JSON Result: `http://localhost:5000/api/json?address=Cairo`
  * XML Result: `http://localhost:5000/api/xml?address=Alex Egypt`
