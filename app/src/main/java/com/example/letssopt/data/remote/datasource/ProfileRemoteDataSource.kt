package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.profile.GetUserInfoResponseDto

interface ProfileRemoteDataSource {
    suspend fun getUserInfo(userId: Int): BaseResponse<GetUserInfoResponseDto>
}
