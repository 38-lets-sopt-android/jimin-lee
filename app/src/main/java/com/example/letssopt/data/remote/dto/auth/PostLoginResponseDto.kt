package com.example.letssopt.data.remote.dto.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostLoginResponseDto(
    @SerialName("userId")
    val userId: Int,
)
