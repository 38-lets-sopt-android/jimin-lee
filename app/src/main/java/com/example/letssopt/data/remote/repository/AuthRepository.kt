package com.example.letssopt.data.remote.repository

import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

interface AuthRepository {
    suspend fun postSignUp(request: PostSignUpRequestDto): Result<Unit>
}
