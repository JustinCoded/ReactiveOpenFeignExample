package com.justincoded.reactiveopenfeigndemo.client

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

object ObjectMapperFactory {

    private val builder = Jackson2ObjectMapperBuilder()
        .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .featuresToDisable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
        .featuresToEnable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE)
        .featuresToEnable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
        .failOnUnknownProperties(false)
        .propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
        .modulesToInstall(JavaTimeModule())
        .modulesToInstall(KotlinModule())

    private val objectMapper: ObjectMapper = builder
        .build<ObjectMapper>()
        .configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true)
        .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)

    fun create(): ObjectMapper {
        return objectMapper
    }

    fun getBuilder(): Jackson2ObjectMapperBuilder {
        return builder
    }
}
