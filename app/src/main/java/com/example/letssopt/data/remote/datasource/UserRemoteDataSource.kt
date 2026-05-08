package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.user.GetUserInfoResponseDto
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto

interface UserRemoteDataSource {
    suspend fun getUserInfo(userId: Int): BaseResponse<GetUserInfoResponseDto>
    suspend fun getUserList(): BaseResponse<GetUserListResponseDto>
}
