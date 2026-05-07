package com.example.letssopt.data.remote.service

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/signup")
    suspend fun postSignUp(
        @Body request: PostSignUpRequestDto,
    ): BaseResponse<Unit>

}
