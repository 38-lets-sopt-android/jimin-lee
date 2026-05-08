package com.example.letssopt.data.remote.dto.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUserListResponseDto(
    @SerialName("users")
    val users: List<UserDto>
)

@Serializable
data class UserDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("part")
    val part: String,
)
