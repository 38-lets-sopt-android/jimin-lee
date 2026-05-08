package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto

interface UserRemoteDataSource {
    suspend fun getUserList(): BaseResponse<GetUserListResponseDto>
}
