package com.example.letssopt.data.remote.repository

import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.core.utils.suspendRunCatching
import com.example.letssopt.data.mapper.user.toProfileModel
import com.example.letssopt.data.mapper.user.toUserListModel
import com.example.letssopt.data.model.ProfileModel
import com.example.letssopt.data.model.UserListModel
import com.example.letssopt.data.remote.datasource.UserRemoteDataSource

class UserRepositoryImpl (
    private val preferencesUtil: PreferencesUtil,
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override suspend fun getUserInfo(): Result<ProfileModel> =
        suspendRunCatching {
            val userId = preferencesUtil.getUserId()
            val response = userRemoteDataSource.getUserInfo(userId).data ?: throw IllegalArgumentException("response data is null")

            response.toProfileModel()
        }

    override suspend fun getUserList(): Result<UserListModel> =
        suspendRunCatching {
            val response = userRemoteDataSource.getUserList().data ?: throw IllegalArgumentException("response data is null")

            response.toUserListModel()
        }
}
