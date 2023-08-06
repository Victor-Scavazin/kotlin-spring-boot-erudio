package br.com.erudio.calculator

import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.service.Converter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController2 {
    val converter : Converter = Converter()
    @RequestMapping(value = ["/sum2/{numbOne}/{numbTwo}"])
    fun sum(
        @PathVariable(value = "numbOne") numbOne: String?,
        @PathVariable(value = "numbTwo") numbTwo: String?,
    ): Double =
        converter.convertToDouble(numbOne) + converter.convertToDouble(numbTwo)



}