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

import java.util.List;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jos.dem.jugoterapia.webflux.model.Category;
import com.jos.dem.jugoterapia.webflux.repository.CategoryRepository;

@SpringBootApplication
public class JugoterapiaApplication {

  @Autowired
  private CategoryRepository categoryRepository;

  private List<Category> categories = Arrays.asList(
      new Category(1, "Curativos"),
      new Category(2, "Energizantes"),
      new Category(3, "Saludables"),
      new Category(4, "Estimulantes"));

	public static void main(String[] args) {
    SpringApplication.run(JugoterapiaApplication.class, args);
	}

  @Bean
  CommandLineRunner start(){
    return args -> {
      categoryRepository.findById(1)
        .subscribe(
            curativos -> System.out.println("Curativos: " + curativos),
            error -> error.printStackTrace(),
            () -> categories.forEach(category -> categoryRepository.save(category).subscribe())
        );
    };
  }

}
