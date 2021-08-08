package com.justincoded.reactiveopenfeigndemo.client

import feign.FeignException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import reactivefeign.spring.config.EnableReactiveFeignClients
import kotlin.system.exitProcess

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@EnableReactiveFeignClients
@EnableFeignClients
@SpringBootApplication(exclude = [WebMvcAutoConfiguration::class])
class ReactiveOpenfeignDemoApplication(
    private val employeeClient: EmployeeClient
) : CommandLineRunner {
    companion object {
        @Suppress("unused") // Used for jar entry and BootJar gradle task
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ReactiveOpenfeignDemoApplication>(*args)
        }
    }

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        logger.info("Running...")

        val blockingEmployee = employeeClient.firstEmployee().block()
        logger.info("Blocking Employee: $blockingEmployee")

        employeeClient.firstEmployee().subscribe({ emp ->
            logger.info("Non-Blocking Employee: $emp")
            exitProcess(0)
        }, { error: Throwable ->
            throw error
        })

//        employeeClient.notFoundEmployee().subscribe({ emp ->
//            logger.info("Non-Blocking Employee: $emp")
//            exitProcess(0)
//        }, { error: Throwable ->
//            logger.error(error.message, error)
//            exitProcess(1)
//        })

        logger.debug("end of method to demonstrate method exec")
    }
}
