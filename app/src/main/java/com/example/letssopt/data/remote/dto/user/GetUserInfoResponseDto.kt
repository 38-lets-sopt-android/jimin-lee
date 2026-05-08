package com.example.letssopt.data.remote.dto.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUserInfoResponseDto(
    @SerialName("id")
    val id: Int,
    @SerialName("loginId")
    val loginId: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("age")
    val age: Int,
    @SerialName("part")
    val part: String,
)
