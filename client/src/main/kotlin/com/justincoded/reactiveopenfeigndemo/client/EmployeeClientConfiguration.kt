package com.justincoded.reactiveopenfeigndemo.client

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import reactivefeign.client.ReactiveHttpRequest
import reactivefeign.client.ReactiveHttpRequestInterceptor
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

class EmployeeClientConfiguration {
    @Bean
    fun interceptor(): ReactiveHttpRequestInterceptor {
        return DebugRequestInterceptor()
    }

    class DebugRequestInterceptor : ReactiveHttpRequestInterceptor {
        val logger : Logger = LoggerFactory.getLogger(javaClass)
        override fun apply(t: ReactiveHttpRequest): Mono<ReactiveHttpRequest> {
            logger.info("url: ${t.uri()}")
            return t.toMono()
        }

    }
}
