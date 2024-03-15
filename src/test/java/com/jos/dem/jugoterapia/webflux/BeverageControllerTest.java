/*
  Copyright 2021 Jose Morales <joseluis.delacruz@gmail.com>
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

import com.jos.dem.jugoterapia.webflux.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.isA;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class BeverageControllerTest {

  private final MockMvc mockMvc;
  private final ApplicationConfig applicationConfig;

  @Test
  @DisplayName("Should get beverage")
  void shouldGetBeverage() throws Exception {
    mockMvc.perform(get("/beverages/{id}", 83))
          .andExpect(status().isOk())
          .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
          .andExpect(jsonPath("$.name").value("Nutritive Carrot Smoothie"))
          .andExpect(jsonPath("$.ingredients").value("4 Carrots,1 Celery Stalk,1 Pear,10 Spinach Leaves"))
          .andExpect(jsonPath("$.image").value(containsString(applicationConfig.getBucketUrl())))
          .andExpect(jsonPath("$.recipe").isNotEmpty());
  }

  @Test
  @DisplayName("Should get beverage by ingredient")
  void shouldGetBeverageByIngredientKeywordIgnoreCase() throws Exception {
    mockMvc.perform(get("/beverages/ingredients/{keyword}", "pear"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$[*].ingredients", everyItem(containsStringIgnoringCase("pear"))));
  }

  @Test
  @DisplayName("Should get beverage by ingredient in capitalize")
  void shouldGetBeverageByIngredientKeyword() throws Exception {
    mockMvc.perform(get("/beverages/ingredients/{keyword}", "Pear"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.*", isA(ArrayList.class)));
  }

}

