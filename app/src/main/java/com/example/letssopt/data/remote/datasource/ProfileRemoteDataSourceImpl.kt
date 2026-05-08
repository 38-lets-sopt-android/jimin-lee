package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.profile.GetUserInfoResponseDto
import com.example.letssopt.data.remote.service.ProfileService

class ProfileRemoteDataSourceImpl (
    private val profileService: ProfileService,
) : ProfileRemoteDataSource {

    override suspend fun getUserInfo(
        userId: Int,
    ): BaseResponse<GetUserInfoResponseDto> {
        return profileService.getUserInfo(
            userId = userId,
        )
    }


}
