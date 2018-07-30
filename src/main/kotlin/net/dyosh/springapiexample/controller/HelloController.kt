package net.dyosh.springapiexample.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/"])
class HelloController {

    /**
     * Hello
     */
    @GetMapping
    fun index(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello Spring")
    }

}