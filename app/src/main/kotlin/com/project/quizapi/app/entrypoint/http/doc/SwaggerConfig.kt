package com.project.quizapi.app.entrypoint.http.doc

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("public-apis")
            .pathsToMatch("/api/end/**", "/api/start/**")
            .build()
    }

    @Bean
    fun internalApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("internal-apis")
            .pathsToMatch("/**")
            .pathsToExclude("/api/end/**", "/api/start/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Quiz API")
                    .description("API para gerenciar um quiz.")
                    .version("v1.0.0")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("Quiz Api Docs")
                    .url("https://github.com/enlaitc/quiz-api")
            )
    }
}