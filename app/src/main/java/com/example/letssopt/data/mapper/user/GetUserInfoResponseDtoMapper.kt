package com.example.letssopt.data.mapper.user

import com.example.letssopt.data.model.ProfileModel
import com.example.letssopt.data.remote.dto.user.GetUserInfoResponseDto

fun GetUserInfoResponseDto.toProfileModel() = ProfileModel(
    id = this.id,
    loginId = this.loginId,
    name = this.name,
    email = this.email,
    age = this.age,
    part = this.part,
)
