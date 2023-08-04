package br.com.erudio.calculator

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {
    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numbOne}/{numbTwo}"])
    fun sum(
        @PathVariable(value = "numbOne") numbOne: String?,
        @PathVariable(value = "numbTwo") numbTwo: String?,
    ): Double {
        if (!isNumeric(numbOne) || !isNumeric(numbTwo)) throw Exception()
        else return convertToDouble(numbOne) + convertToDouble(numbTwo)
    }

    private fun isNumeric(str: String?): Boolean {
        if (str.isNullOrBlank()) return false
        return str.matches("""[+-]?[0-9]*\.?[0-9]+]""".toRegex())
    }

    private fun convertToDouble(strNumb: String?): Double {
        if (strNumb.isNullOrBlank()) return 0.0

        val number = strNumb.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }
}