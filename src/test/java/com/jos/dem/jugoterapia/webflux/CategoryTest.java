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

import reactor.core.publisher.Flux;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.jos.dem.jugoterapia.webflux.model.Category;
import com.jos.dem.jugoterapia.webflux.service.CategoryService;
import com.jos.dem.jugoterapia.webflux.service.impl.CategoryServiceImpl;
import com.jos.dem.jugoterapia.webflux.repository.CategoryRepository;

public class CategoryTest {

  @InjectMocks
  private CategoryService service = new CategoryServiceImpl();

  @Mock
  private CategoryRepository categoryRepository;

  @BeforeEach
	void init_mocks() {
    MockitoAnnotations.initMocks(this);
	}

  @Test
  void shouldFindAllCategories() throws Exception {
    when(categoryRepository.findAll()).thenReturn(Flux.just(new Category(1, "Curativos")));
    service.findAll();
    verify(categoryRepository).findAll();
  }

}

