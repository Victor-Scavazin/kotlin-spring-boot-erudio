package br.com.erudio.calculator

import br.com.erudio.Person
import br.com.erudio.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @RequestMapping(
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun findAll(): List<Person> {
        return personService.findAll()
    }
    @RequestMapping(
        value = ["/{id}"],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun findById(@PathVariable(value = "id") id: Long): Person {
        return personService.findById(id)
    }
    @RequestMapping(
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun create(@RequestBody person: Person) : Person{
        return personService.create(person)
    }
    @RequestMapping(
        method = [RequestMethod.PUT],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun update(@RequestBody person: Person) : Person{
        return personService.create(person)
    }
    @RequestMapping(value = ["/{id}"],
        method = [RequestMethod.DELETE],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun delete(@RequestParam(value = "id") id: Long) {
        return personService.delte(id)
    }

}