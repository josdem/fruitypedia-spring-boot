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
import com.jos.dem.jugoterapia.webflux.model.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.http.MediaType.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  @DisplayName("Should get all categories")
  void shouldGetCategories() throws Exception {
    webClient.get().uri("/categories/")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBodyList(Category.class);
  }

  @Test
  @DisplayName("Should get categories in spanish")
  void shouldGetCategoriesByLanguage() throws Exception {
    webClient.get().uri("/categories/{language}", "es")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBodyList(Category.class)
            .value(categories -> categories.size(), equalTo(4))
            .value(categories -> categories.get(0).getName(), equalTo("Curativos"))
            .value(categories -> categories.get(1).getName(), equalTo("Saludables"))
            .value(categories -> categories.get(2).getName(), equalTo("Energizantes"))
            .value(categories -> categories.get(3).getName(), equalTo("Estimulantes"));
  }

  @Test
  @DisplayName("Should get categories by id")
  public void shouldGetBeveragesByCategory() throws Exception {
    webClient.get().uri("/categories/{id}/beverages", 1)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_VALUE)
            .expectBodyList(Beverage.class);
  }

}

