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

package com.jos.dem.jugoterapia.webflux.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.Arrays;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  private String swaggerServer;

  public SwaggerConfig(@Value("${swagger.server}") String swaggerServer) {
    this.swaggerServer = swaggerServer;
  }

  @Bean
  public OpenAPI springShopOpenAPI() {
    return new OpenAPI()
        .servers(Arrays.asList(new Server().url(swaggerServer)))
        .info(
            new Info()
                .title("Fruitypedia API Docs")
                .description("Fruitypedia REST API documentation")
                .version("v1.0.0"));
  }

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder().group("fruitypedia").pathsToMatch("/**").build();
  }
}
