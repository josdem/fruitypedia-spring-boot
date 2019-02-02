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

package com.jos.dem.jugoterapia.webflux.config;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.jos.dem.jugoterapia.webflux.repository.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Bootstrap implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  private CategoryRepository categoryRepository;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    log.info("Trying to load categories...");
    validateCategories();
  }

  private void validateCategories(){
    categoryRepository.findAll().subscribe(System.out::println);
  }

}

