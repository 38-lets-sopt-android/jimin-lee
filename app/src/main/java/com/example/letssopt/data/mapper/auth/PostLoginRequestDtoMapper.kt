package com.example.letssopt.data.mapper.auth

import com.example.letssopt.data.model.LoginModel
import com.example.letssopt.data.remote.dto.auth.PostLoginRequestDto

fun LoginModel.toPostLoginRequestDto() = PostLoginRequestDto(
    loginId = this.id,
    password = this.password,
)
