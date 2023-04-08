package br.com.erudio

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {
    val counter : AtomicLong = AtomicLong()
    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "2.3") name:Double) : Greeting {
        val x =name*2
        return Greeting(counter.incrementAndGet(), "Hello, $x")
    }
}