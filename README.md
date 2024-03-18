fruitypedia-spring-boot
----------------------------------------------

[![GitHub](https://github.com/josdem/jugoterapia-webflux/actions/workflows/main.yml/badge.svg)](https://github.com/josdem/jugoterapia-webflux/actions)
[![Quality Gate Status](https://sonar.josdem.io/api/project_badges/measure?project=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux&metric=alert_status)](https://sonar.josdem.io/dashboard?id=com.jos.dem.jugoterapia.webflux%3Ajugoterapia-webflux)

Fruitypedia is an Android application helping to improve your health based in smoothie recipes, this project is the server side, it is exposing recipes and beverages as API service using [Spring Framework](https://docs.spring.io/spring-framework/reference/web.html).

#### Configuration

[Wiki page](https://github.com/josdem/fruitypedia-spring-boot/wiki)

#### Swagger

https://webflux.josdem.io/swagger-ui.html

#### To run tests

```bash
gradle test
```

#### To run tests with Jacoco and Sonarqube

```bash
gradle test jacocoTestReport sonarqube
```

#### To run the project

```bash
gradle bootRun
```

**Note:** Make sure you set your database credentials in the `src/main/resources/application.yml`

#### Go here for more information

https://josdem.io/fruitypedia/fruitypedia/

