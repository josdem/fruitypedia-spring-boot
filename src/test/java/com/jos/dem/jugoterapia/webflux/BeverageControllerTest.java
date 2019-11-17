/*
  Copyright 2018 José Luis De la Cruz Morales <joseluis.delacruz@gmail.com>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.jugoterapia.webflux;

import com.jos.dem.jugoterapia.webflux.model.Beverage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BeverageControllerTest {

  @Value("${bucket.url}")
  private String bucketUrl;

  @Autowired
  private WebTestClient webClient;

  @Test
  @DisplayName("Should get beverage")
  void shouldGetBeverage() {
    webClient.get().uri("/beverages/{id}", 83)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBody(Beverage.class)
            .value(beverage -> beverage.getName(), equalTo("Nutritive Carrot Smoothie"))
            .value(beverage -> beverage.getIngredients(), equalTo("4 Carrots,1 Celery Stalk,1 Pear,10 Spinach Leaves"))
            .value(beverage -> beverage.getImage(), containsString(bucketUrl))
            .value(beverage -> beverage.getRecipe(), notNullValue());
  }

  @Test
  @DisplayName("Should get beverage by ingredient")
  void shouldGetBeverageByIngredientKeywordIgnoreCase() {
    webClient.get().uri("/beverages/ingredients/{keyword}", "pear")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBodyList(Beverage.class)
            .value(beverages ->
                    beverages.forEach( beverage ->
                            assertTrue(beverage.getIngredients().toLowerCase().contains("pear"))));
  }

  @Test
  @DisplayName("Should get beverage by ingredient in capitalize")
  void shouldGetBeverageByIngredientKeyword() {
    webClient.get().uri("/beverages/ingredients/{keyword}", "Pear")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBodyList(Beverage.class);
  }

}

