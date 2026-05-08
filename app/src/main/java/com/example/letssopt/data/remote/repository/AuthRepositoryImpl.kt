package com.example.letssopt.data.remote.repository

import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.core.utils.suspendRunCatching
import com.example.letssopt.data.mapper.auth.toUserIdModel
import com.example.letssopt.data.model.UserIdModel
import com.example.letssopt.data.remote.datasource.AuthRemoteDataSource
import com.example.letssopt.data.remote.dto.auth.PostLoginRequestDto
import com.example.letssopt.data.remote.dto.auth.PostSignUpRequestDto

class AuthRepositoryImpl (
    private val preferencesUtil: PreferencesUtil,
    private val authRemoteDataSource: AuthRemoteDataSource,
) : AuthRepository {

    override suspend fun postSignUp(request: PostSignUpRequestDto): Result<Unit> =
        suspendRunCatching {
            authRemoteDataSource.postSignUp(request)
        }

    override suspend fun postLogin(request: PostLoginRequestDto): Result<UserIdModel> =
        suspendRunCatching {
            val response = authRemoteDataSource.postLogin(request).data ?: throw IllegalArgumentException("response data is null")
            preferencesUtil.setAutoLogin(true, response.userId)

            response.toUserIdModel()
        }
}
