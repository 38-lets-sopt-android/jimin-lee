package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.user.GetUserInfoResponseDto
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto
import com.example.letssopt.data.remote.service.UserService

class UserRemoteDataSourceImpl (
    private val userService: UserService,
) : UserRemoteDataSource {

    override suspend fun getUserInfo(
        userId: Int,
    ): BaseResponse<GetUserInfoResponseDto> {
        return userService.getUserInfo(
            userId = userId,
        )
    }

    override suspend fun getUserList(): BaseResponse<GetUserListResponseDto> {
        return userService.getUserList()
    }

}
