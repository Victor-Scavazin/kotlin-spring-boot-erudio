package br.com.erudio.exceptions.handler

import br.com.erudio.exceptions.ExceptionResponse
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@RestController
@ControllerAdvice // This annotation is used to handle exceptions globally
class CustomizedResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            message = ex.message,
            details = request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
    @ExceptionHandler(UnsupportedMathOperationException::class)
    fun handleBadRequestExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            message = ex.message,
            details = request.getDescription(true)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFoundRequestExceptions(ex: Exception, request: WebRequest):
            ResponseEntity<ExceptionResponse> {

        val exceptionResponse = ExceptionResponse(
            timestamp = Date(),
            message = ex.message,
            details = request.getDescription(true)
        )
        return ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND)
    }

}