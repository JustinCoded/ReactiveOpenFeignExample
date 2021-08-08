package com.justincoded.reactiveopenfeigndemo.client

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class ObjectMapperConfiguration {
    @Primary
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapperFactory.create().findAndRegisterModules()
    }
}
