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

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Arrays;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.jos.dem.jugoterapia.webflux.model.Category;
import com.jos.dem.jugoterapia.webflux.model.Beverage;
import com.jos.dem.jugoterapia.webflux.service.BeverageService;
import com.jos.dem.jugoterapia.webflux.service.impl.BeverageServiceImpl;
import com.jos.dem.jugoterapia.webflux.repository.BeverageRepository;

public class BeverageTest {

  @InjectMocks
  private BeverageService service = new BeverageServiceImpl();

  @Mock
  private BeverageRepository beverageRepository;

  private Integer beverageId = 66;
  private Integer categoryId = 3;
  private Beverage beverage = new Beverage(beverageId, "Jugo nutritivo", "4 Zanahorias,1 Tallo de apío,1 Pera,5 hojas de espinacas", "Lava perfectamente todos los ingrendientes", categoryId);

  @BeforeEach
	void setup() {
    MockitoAnnotations.initMocks(this);
	}

  @Test
  @DisplayName("Should find by id")
  void shouldFindById() throws Exception {
    when(beverageRepository.findById(beverageId)).thenReturn(Mono.just(beverage));
    service.findById(beverageId);
    verify(beverageRepository).findById(beverageId);
  }

  @Test
  @DisplayName("Should find by category id")
  void shouldFindCategoryById() throws Exception {
    when(beverageRepository.findById(categoryId)).thenReturn(Mono.just(beverage));
    service.findByCategoryId(categoryId);
    verify(beverageRepository).findByCategoryId(categoryId);
  }

}

