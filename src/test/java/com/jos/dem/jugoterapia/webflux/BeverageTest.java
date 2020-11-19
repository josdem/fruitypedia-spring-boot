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
import com.jos.dem.jugoterapia.webflux.repository.BeverageRepository;
import com.jos.dem.jugoterapia.webflux.service.BeverageService;
import com.jos.dem.jugoterapia.webflux.service.impl.BeverageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class BeverageTest {

  @Mock
  private BeverageRepository beverageRepository;

  private BeverageService service;

  private Integer beverageId = 66;
  private Integer categoryId = 3;
  private String keyword = "pear";
  private Beverage beverage = new Beverage(beverageId, "Jugo nutritivo", "4 Zanahorias,1 Tallo de apío,1 Pera,5 hojas de espinacas", "Lava perfectamente todos los ingrendientes","imageUrl",categoryId);

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    service = new BeverageServiceImpl(beverageRepository);
  }

  @Test
  @DisplayName("Should find by id")
  void shouldFindById() throws Exception {
    service.findById(beverageId);
    verify(beverageRepository).findById(beverageId);
  }

  @Test
  @DisplayName("Should find by category id")
  void shouldFindByCateogryId() throws Exception {
    service.findByCategoryId(categoryId);
    verify(beverageRepository).findByCategoryId(categoryId);
  }

  @Test
  @DisplayName("Should find by ingredient keyword")
  void shouldFindByIngredientKeyword() throws Exception {
    service.findByIngredientKeyword(keyword);
    verify(beverageRepository).findByIngredientsLikeIgnoreCase(keyword);
  }

}

