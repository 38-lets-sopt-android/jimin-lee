package com.example.letssopt.data.remote.service

import com.example.letssopt.data.remote.dto.BaseResponse
import com.example.letssopt.data.remote.dto.profile.GetUserInfoResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileService {
    @GET("/api/v1/users/{userId}")
    suspend fun getUserInfo(
        @Path("userId")
        userId: Int,
    ): BaseResponse<GetUserInfoResponseDto>

}
