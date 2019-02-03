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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import com.jos.dem.jugoterapia.webflux.model.Category;
import com.jos.dem.jugoterapia.webflux.controller.CategoryController;

@RunWith(SpringRunner.class)
@WebFluxTest
public class CategoryControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void shouldGetCategories() throws Exception {
    webClient.post().uri("/categories").accept(APPLICATION_JSON)
      .exchange()
		  .expectStatus().isOk()
      .expectHeader().contentType(APPLICATION_JSON)
      .expectBodyList(Category.class);
  }

  @Test
  public void shouldGetCategoriesByLanguage() throws Exception {
    webClient.post().uri("/categoriesi/{language}", "es").accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(APPLICATION_JSON)
      .expectBodyList(Category.class);
  }

}

