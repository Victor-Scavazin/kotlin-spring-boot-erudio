package br.com.erudio.service

import br.com.erudio.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")
        //Mock
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Leandro"
        person.lastName = "Costa"
        person.address = "Uberlandia - Minas Gerais - Brasil"
        person.gender = "Male"
        return person
    }

    fun findAll(): List<Person> {
        logger.info("Finding all person!")
        //Mock
        val persons: MutableList<Person> = mutableListOf()
        for (i in 0..7) {
            persons.add(mockPerson(i))
        }
        return persons
    }

    fun create(person: Person) = person
    fun update(person: Person) = person
    fun delte(id: Long){}

    fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person $i"
        person.lastName = "Last Name $i"
        person.address = "Uberlandia - Minas Gerais - Brasil"
        person.gender = "Male"
        return person
    }
}
