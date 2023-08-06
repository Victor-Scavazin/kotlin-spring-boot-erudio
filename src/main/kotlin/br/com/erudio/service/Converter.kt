package br.com.erudio.service

import br.com.erudio.exceptions.UnsupportedMathOperationException

class Converter {
    fun isNumeric(str: String?): Boolean {
        if (str.isNullOrBlank()) return false
        return str.matches("""[+-]?[0-9]*\.?[0-9]+""".toRegex())
    }

    fun convertToDouble(strNumb: String?): Double {
        if (strNumb.isNullOrBlank()) return 0.0

        val number = strNumb.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else
            throw UnsupportedMathOperationException("Please set a numeric value!")

    }
}