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

package com.jos.dem.jugoterapia.webflux.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Beverage {

  @Id
  private Integer id;
  private String name;
  private String ingredients;
  private String recipe;
  private String image;
  @JsonIgnore
  private Integer categoryId;

  public Beverage(Integer id, String name, String ingredients, String recipe, String image, Integer categoryId){
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.recipe = recipe;
    this.image = image;
    this.categoryId = categoryId;
  }

  public Integer getId(){
    return id;
  }

  public String getName(){
    return name;
  }

  public String getIngredients(){
    return ingredients;
  }

  public String getRecipe(){
    return recipe;
  }

  public String getImage(){
    return image;
  }

}
