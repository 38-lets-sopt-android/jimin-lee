package com.example.letssopt.data.remote.service

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.user.GetUserInfoResponseDto
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/api/v1/users/{userId}")
    suspend fun getUserInfo(
        @Path("userId")
        userId: Int,
    ): BaseResponse<GetUserInfoResponseDto>

    @GET("/api/v1/users")
    suspend fun getUserList(): BaseResponse<GetUserListResponseDto>

}
