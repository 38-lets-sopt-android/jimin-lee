package com.example.letssopt.data.mapper.auth

import com.example.letssopt.data.model.UserIdModel
import com.example.letssopt.data.remote.dto.auth.PostLoginResponseDto

fun PostLoginResponseDto.toUserIdModel() = UserIdModel(
    userId = this.userId,
)
