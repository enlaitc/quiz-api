package com.project.quizapi.app.entrypoint.http

import com.project.quizapi.domain.entity.CategoryEntity
import com.project.quizapi.domain.usecase.TesteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class TesteController( val testeUseCase: TesteUseCase) {

    @GetMapping("/teste/{param}")
    fun nomeDoFan(@PathVariable param:String):String{
        return "Você digitou $param"
    }

    @GetMapping("/usecase")
    fun teste():String{
        return testeUseCase.teste()
    }

    @GetMapping("/db")
    fun testeDb():MutableList<CategoryEntity>{
        return testeUseCase.db()
    }
}