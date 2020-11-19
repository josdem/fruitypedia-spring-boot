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

package com.jos.dem.jugoterapia.webflux.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

import com.jos.dem.jugoterapia.webflux.model.Beverage;
import com.jos.dem.jugoterapia.webflux.service.BeverageService;

@Api(tags = {"knows how receive manage beverage requests"})
@Slf4j
@RestController
@RequestMapping("/beverages")
@RequiredArgsConstructor
public class BeverageController {

  private final BeverageService beverageService;

  @ApiImplicitParam(name = "id", value = "Beverage's id", required = true, dataType = "int", paramType = "path")
  @GetMapping("/{id}")
  public Mono<Beverage> getBeverage(@PathVariable("id") Integer beverageId){
    log.info("Listing beverages by id: {}", beverageId);
    return beverageService.findById(beverageId);
  }

  @ApiImplicitParam(name = "keyword", value = "Beverage ingredients contain keyword", required = true, dataType = "string", paramType = "path")
  @GetMapping("/ingredients/{keyword}")
  public Flux<Beverage> getBeverageByKeyword(@PathVariable("keyword") String keyword){
    log.info("Listing beverages where ingredients contains: {}", keyword);
    return beverageService.findByIngredientKeyword(keyword);
  }

}
