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

import com.jos.dem.jugoterapia.webflux.model.Beverage;
import com.jos.dem.jugoterapia.webflux.service.BeverageService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "knows how receive manage beverage requests")
@Slf4j
@RestController
@RequestMapping("/beverages")
@RequiredArgsConstructor
public class BeverageController {

  private final BeverageService beverageService;

  @Parameter(name = "id", description = "Beverage's id", required = true)
  @GetMapping("/{id}")
  public Beverage getBeverage(@PathVariable("id") Integer beverageId) {
    log.info("Listing beverages by id: {}", beverageId);
    return beverageService
        .findById(beverageId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Parameter(
      name = "keyword",
      description = "Beverage ingredients contain keyword",
      required = true)
  @GetMapping("/ingredients/{keyword}")
  public List<Beverage> getBeverageByKeyword(@PathVariable("keyword") String keyword) {
    log.info("Listing beverages where ingredients contains: {}", keyword);
    return beverageService.findByIngredientKeyword(keyword);
  }
}
