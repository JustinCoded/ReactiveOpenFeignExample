package com.justincoded.reactiveopenfeigndemo.fluxapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FluxApiApplication {
	companion object {
		@Suppress("unused") // Used for jar entry and BootJar gradle task
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<FluxApiApplication>(*args)
		}
	}
}
