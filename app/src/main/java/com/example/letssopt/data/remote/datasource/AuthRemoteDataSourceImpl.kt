package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto
import com.example.letssopt.data.remote.service.AuthService

class AuthRemoteDataSourceImpl (
    private val authService: AuthService,
) : AuthRemoteDataSource {

    override suspend fun postSignUp(request: PostSignUpRequestDto): BaseResponse<Unit> {
        return authService.postSignUp(request = request)
    }

}
