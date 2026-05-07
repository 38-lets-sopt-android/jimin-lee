package com.example.letssopt.data.remote.repository

import com.example.letssopt.core.utils.suspendRunCatching
import com.example.letssopt.data.remote.datasource.AuthRemoteDataSource
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

class AuthRepositoryImpl (
    private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {

    override suspend fun postSignUp(request: PostSignUpRequestDto): Result<Unit> =
        suspendRunCatching {
            authRemoteDataSource.postSignUp(request)
        }
}
