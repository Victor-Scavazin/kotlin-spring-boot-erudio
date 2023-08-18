package br.com.erudio.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "id",
    "lastName",
    "address",
    "gender",
    "firstName"
)
data class PersonVO(
    var id: Long = 0,
    @field:JsonProperty("first_name")
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    @field:JsonIgnore
    var gender: String = ""
)