package com.example.letssopt.data.remote.repository

import com.example.letssopt.data.model.UserIdModel
import com.example.letssopt.data.remote.dto.auth.PostLoginRequestDto
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

interface AuthRepository {
    suspend fun postSignUp(request: PostSignUpRequestDto): Result<Unit>
    suspend fun postLogin(request: PostLoginRequestDto): Result<UserIdModel>
}
