package com.jos.dem.jugoterapia.webflux.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SwaggerConfigTest {

    private static final String SWAGGER_SERVER = "http://localhost:8080";

    private SwaggerConfig swaggerConfig;

    @BeforeEach
    void setup() {
        swaggerConfig = new SwaggerConfig(SWAGGER_SERVER);
    }

    @Test
    @DisplayName("adds Swagger service")
    void shouldAddSwaggerService(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());
        assertEquals(1, swaggerConfig.springShopOpenAPI().getServers().size(), "should have one server");
        assertEquals(
                SWAGGER_SERVER,
                swaggerConfig.springShopOpenAPI().getServers().get(0).getUrl(),
                "should have expected server");
    }
}
