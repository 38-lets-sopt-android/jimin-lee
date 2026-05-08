package com.example.letssopt.data.mapper.profile

import com.example.letssopt.data.model.ProfileModel
import com.example.letssopt.data.remote.dto.profile.GetUserInfoResponseDto

fun GetUserInfoResponseDto.toProfileModel() = ProfileModel(
    id = this.id,
    loginId = this.loginId,
    name = this.name,
    email = this.email,
    age = this.age,
    part = this.part,
)
