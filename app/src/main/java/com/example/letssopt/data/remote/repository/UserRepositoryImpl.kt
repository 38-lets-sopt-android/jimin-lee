package com.example.letssopt.data.remote.repository

import com.example.letssopt.core.utils.suspendRunCatching
import com.example.letssopt.data.mapper.user.toUserListModel
import com.example.letssopt.data.model.UserListModel
import com.example.letssopt.data.remote.datasource.UserRemoteDataSource

class UserRepositoryImpl (
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override suspend fun getUserList(): Result<UserListModel> =
        suspendRunCatching {
            val response = userRemoteDataSource.getUserList().data ?: throw IllegalArgumentException("response data is null")

            response.toUserListModel()
        }
}
