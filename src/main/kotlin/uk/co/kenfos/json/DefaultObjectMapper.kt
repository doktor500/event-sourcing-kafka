package uk.co.kenfos.json

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

abstract class DefaultObjectMapper {
    protected val mapper: ObjectMapper = ObjectMapper().registerKotlinModule().setPropertyNamingStrategy(SNAKE_CASE)
}