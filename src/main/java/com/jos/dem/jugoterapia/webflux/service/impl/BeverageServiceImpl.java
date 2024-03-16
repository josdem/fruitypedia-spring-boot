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

package com.jos.dem.jugoterapia.webflux.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.jos.dem.jugoterapia.webflux.model.Beverage;
import com.jos.dem.jugoterapia.webflux.service.BeverageService;
import com.jos.dem.jugoterapia.webflux.repository.BeverageRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {

  private final BeverageRepository beverageRepository;

  public Optional<Beverage> findById(Integer beverageId){
    return beverageRepository.findById(beverageId);
  }

  public List<Beverage> findByCategoryId(Integer categoryId){
    return beverageRepository.findByCategoryId(categoryId);
  }

  public List<Beverage> findByIngredientKeyword(String keyword){
    return beverageRepository.findByIngredientsLikeIgnoreCase(keyword);
  }

}

