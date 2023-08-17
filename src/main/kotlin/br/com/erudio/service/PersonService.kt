package br.com.erudio.service

import br.com.erudio.data.vo.v2.PersonVO as pVO2
import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.mapper.DozerMapper
import br.com.erudio.mapper.PersonMapper
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var pMapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): PersonVO {
        logger.info("Finding one person!")
        val person = personRepository.findById(id).orElseThrow { ResourceNotFoundException("No records found for this ID") }
        return DozerMapper.parseObject(person, PersonVO::class.java)
    }

    fun findAll(): List<PersonVO> {
        logger.info("Finding all person!")
        //Mock
        val persons =  personRepository.findAll()
        return DozerMapper.parseListObjects(persons, PersonVO::class.java)

    }

    fun create(personVO: PersonVO) : PersonVO {
        logger.info("Creating a new person with name: ${personVO.firstName}!")
        val entity : Person = DozerMapper.parseObject(personVO, Person::class.java)
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun update(personVO: PersonVO) :PersonVO{
        logger.info("Updating a new person with name: ${personVO.firstName}!")
        val entity = personRepository.findById(personVO.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        entity.firstName = personVO.firstName
        entity.lastName = personVO.lastName
        entity.address = personVO.address
        entity.gender = personVO.gender
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun delete(id: Long) {
        logger.info("Deleting a person with id: $id!")
        val entity = personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID") }
        personRepository.delete(entity)
    }

    fun createV2(person: pVO2): pVO2 {
        logger.info("Creating a new person with name: ${person.firstName}!")
        val entity : Person = pMapper.mapVOToEntity(person)
        return pMapper.mapEntityToVO(personRepository.save(entity))
    }

}
