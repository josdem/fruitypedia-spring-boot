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

package com.josdem.fruitypedia.controller;

import com.josdem.fruitypedia.model.Beverage;
import com.josdem.fruitypedia.model.Category;
import com.josdem.fruitypedia.service.BeverageService;
import com.josdem.fruitypedia.service.CategoryService;
import com.josdem.fruitypedia.util.LanguageResolver;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "knows how receive manage category requests")
@Slf4j
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;
  private final BeverageService beverageService;
  private final LanguageResolver languageResolver;

  @GetMapping("/")
  public List<Category> getCategories() {
    log.info("Listing categories");
    return categoryService.findByI18n("es");
  }

  @Parameter(name = "language", description = "Language required", required = true)
  @GetMapping("/{language}")
  public List<Category> getCategories(@PathVariable("language") String language) {
    log.info("Listing categories");
    return categoryService.findByI18n(languageResolver.resolve(language));
  }

  @Parameter(name = "id", description = "Category's id", required = true)
  @GetMapping(value = "/{id}/beverages")
  public List<Beverage> getBeverages(@PathVariable("id") Integer categoryId) {
    log.info("Listing beverages by category: {}", categoryId);
    return beverageService.findByCategoryId(categoryId);
  }
}
