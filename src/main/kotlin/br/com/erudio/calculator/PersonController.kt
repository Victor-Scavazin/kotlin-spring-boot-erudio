package br.com.erudio.calculator

import br.com.erudio.model.Person
import br.com.erudio.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/person")
class PersonController {
    @Autowired
    private lateinit var personService: PersonService

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun findAll(): List<Person> {
        return personService.findAll()
    }
    @GetMapping(
        value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun findById(@PathVariable(value = "id") id: Long): Person {
        return personService.findById(id)
    }
    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun create(@RequestBody person: Person) : Person {
        return personService.create(person)
    }
    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun update(@RequestBody person: Person) : Person {
        return personService.update(person)
    }
    @DeleteMapping(value = ["/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]//"application/json"
    )
    fun delete(@PathVariable(value = "id") id: Long) : ResponseEntity<*>{
        personService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }

}