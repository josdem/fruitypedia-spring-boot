Jugoterapia Webflux
----------------------------------------------

[![Build Status](https://travis-ci.com/josdem/jugoterapia-webflux.svg?branch=master)](https://travis-ci.com/josdem/jugoterapia-webflux)
[![Quality Gate Status](https://sonar.josdem.io/api/project_badges/measure?project=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux&metric=alert_status)](https://sonar.josdem.io/dashboard?id=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux)

Jugoterapia is an Android application mainly focused in improve your healty based in juice recipes, this project is the server side, it is exposing recipes and beverages as API service using [Spring Webflux Framework](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html).

#### Configuration

https://github.com/josdem/jugoterapia-webflux/wiki

#### To run tests

```bash
gradle test -Dspring.data.mongodb.username=username -Dspring.data.mongodb.password=password
```

#### To run the project

```bash
gradle bootRun -Dspring.data.mongodb.username=username -Dspring.data.mongodb.password=password
```

#### Go here for more information

https://josdem.io/jugoterapia/jugoterapia/

