package com.example.letssopt.data.mapper.auth

import com.example.letssopt.data.model.SignUpModel
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

fun SignUpModel.toPostSignUpRequestDto() = PostSignUpRequestDto(
    loginId = this.id,
    password = this.password,
    name = this.name,
    email = this.email,
    age = this.age,
    part = this.part,
)
