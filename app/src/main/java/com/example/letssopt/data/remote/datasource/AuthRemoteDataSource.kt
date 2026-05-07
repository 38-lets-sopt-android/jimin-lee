package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

interface AuthRemoteDataSource {
    suspend fun postSignUp(request: PostSignUpRequestDto): BaseResponse<Unit>
}
