package com.justincoded.reactiveopenfeigndemo.fluxapi.controllers

import com.justincoded.reactiveopenfeigndemo.fluxapi.models.Employee
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@RestController
@RequestMapping("/employees")
class EmployeeController {
    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Int): ResponseEntity<Mono<Employee>> {
        return if (id == 1 ) {
            ResponseEntity.ok(Employee(name = "The Dude").toMono())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
