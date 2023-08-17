package br.com.erudio.mapper

import br.com.erudio.data.vo.v2.PersonVO
import br.com.erudio.model.Person
import org.springframework.stereotype.Service

@Service
class PersonMapper {
    fun mapEntityToVO(person: Person):PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.gender = person.gender
        vo.address = person.address
        return vo
    }
    fun mapVOToEntity(vo: PersonVO):Person {
        val person = Person()
        person.id = vo.id
        person.firstName = vo.firstName
        person.lastName = vo.lastName
        person.gender = vo.gender
        person.address = vo.address
        //person.birthDate = vo.birthDate
        return person
    }
}