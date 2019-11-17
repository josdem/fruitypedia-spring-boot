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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HealthControllerTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  public void shouldGetPong() throws Exception {
    webClient.get().uri("/health/{ping}", "ping")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(APPLICATION_JSON_UTF8_VALUE)
            .expectBody(String.class).isEqualTo("pong");
  }

}
