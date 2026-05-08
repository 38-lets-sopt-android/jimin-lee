package com.example.letssopt.data.remote.repository

import com.example.letssopt.core.utils.PreferencesUtil
import com.example.letssopt.core.utils.suspendRunCatching
import com.example.letssopt.data.mapper.profile.toProfileModel
import com.example.letssopt.data.model.ProfileModel
import com.example.letssopt.data.remote.datasource.ProfileRemoteDataSource

class ProfileRepositoryImpl (
    private val preferencesUtil: PreferencesUtil,
    private val profileRemoteDataSource: ProfileRemoteDataSource,
) : ProfileRepository {

    override suspend fun getUserInfo(): Result<ProfileModel> =
        suspendRunCatching {
            val userId = preferencesUtil.getUserId()
            val response = profileRemoteDataSource.getUserInfo(userId).data ?: throw IllegalArgumentException("response data is null")

            response.toProfileModel()
        }

}
