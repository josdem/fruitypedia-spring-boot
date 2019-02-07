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

import static org.junit.Assume.assumeFalse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.jos.dem.jugoterapia.webflux.model.Beverage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class BeverageControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Before
  public void before() {
    assumeFalse(System.getenv("USER").equals("travis"));
  }

  @Test
  public void shouldGetBeverage() throws Exception {
    webClient.get().uri("/beverages/{id}", 83).accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(APPLICATION_JSON_UTF8)
      .expectBody(Beverage.class);
  }

  @Test
  public void shouldGetBeverageByIngredientKeyword() throws Exception {
    webClient.get().uri("/beverages/ingredients/{keyword}", "Pear").accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectHeader().contentType(APPLICATION_JSON_UTF8)
      .expectBody(Beverage.class);
  }

}

