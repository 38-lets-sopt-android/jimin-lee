package com.example.letssopt.data.remote.datasource

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto
import com.example.letssopt.data.remote.service.UserService

class UserRemoteDataSourceImpl (
    private val userService: UserService,
) : UserRemoteDataSource {

    override suspend fun getUserList(): BaseResponse<GetUserListResponseDto> {
        return userService.getUserList()
    }

}
