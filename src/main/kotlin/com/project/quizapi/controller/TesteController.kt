package com.project.quizapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class TesteController {

    @GetMapping("/teste/{param}")
    fun nomeDoFan(@PathVariable param:String):String{
        return "Você digitou $param"
    }
}