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
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.server.reactive.ServerHttpRequest;

import com.jos.dem.jugoterapia.webflux.util.LanguageResolver;

class LanguageResolverTest {

  private LanguageResolver languageResolver = new LanguageResolver();

  @Mock
  private ServerWebExchange exchange;
  @Mock
  private ServerHttpRequest request;
  @Mock
  private HttpHeaders headers;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    when(request.getHeaders()).thenReturn(headers);
    when(exchange.getRequest()).thenReturn(request);
  }

  @Test
  @DisplayName("Should read English language")
  void shouldReadEnglish() throws Exception {
    when(headers.getFirst("Accept-Language")).thenReturn("en");
    assertEquals("en",languageResolver.resolve(exchange));
  }

  @Test
  @DisplayName("Should read Spanish as default language")
  void shouldReadSpanishAsDefault() throws Exception {
    assertEquals("es",languageResolver.resolve(exchange));
  }

}

