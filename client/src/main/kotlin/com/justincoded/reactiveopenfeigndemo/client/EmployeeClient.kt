package com.justincoded.reactiveopenfeigndemo.client

import com.justincoded.reactiveopenfeigndemo.client.models.Employee
import org.springframework.web.bind.annotation.GetMapping
import reactivefeign.spring.config.ReactiveFeignClient
import reactor.core.publisher.Mono

// no client load balancer = @ReactiveFeignClient(name = "employee-client", url = "\${employee-client.url}")
@ReactiveFeignClient(name = "employee-client")
interface EmployeeClient {
    @GetMapping("/employees/1")
    fun firstEmployee(): Mono<Employee>

    @GetMapping("/employees/2")
    fun notFoundEmployee(): Mono<Employee>
}
