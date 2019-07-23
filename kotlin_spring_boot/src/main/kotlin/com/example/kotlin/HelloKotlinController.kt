package com.example.kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/hello")
class HelloKotlinController{

    @GetMapping
    fun hello() = "hello kotlin"

}