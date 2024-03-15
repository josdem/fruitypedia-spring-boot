Jugoterapia
----------------------------------------------

[![Build Status](https://travis-ci.com/josdem/jugoterapia-webflux.svg?branch=master)](https://travis-ci.com/josdem/jugoterapia-webflux)
[![Quality Gate Status](https://sonar.josdem.io/api/project_badges/measure?project=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux&metric=alert_status)](https://sonar.josdem.io/dashboard?id=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux)

Jugoterapia is an Android application mainly focused in improve your healty based in juice recipes, this project is the server side, it is exposing recipes and beverages as API service using [Spring Framework](https://docs.spring.io/spring-framework/reference/web.html).

#### Configuration

https://github.com/josdem/jugoterapia-webflux/wiki

#### Swagger

https://webflux.josdem.io/swagger-ui.html

#### To run tests

```bash
gradle test -Dspring.data.mongodb.username=username -Dspring.data.mongodb.password=password
```

#### To run tests with Jacoco and Sonarqube

```bash
gradle test jacocoTestReport sonarqube -Dspring.data.mongodb.username=username -Dspring.data.mongodb.password=password
```

#### To run the project

```bash
gradle bootRun -Dspring.data.mongodb.username=username -Dspring.data.mongodb.password=password
```

#### Go here for more information

https://josdem.io/jugoterapia/jugoterapia/

