package com.example.letssopt.data.remote.repository

import com.example.letssopt.data.model.ProfileModel

interface ProfileRepository {
    suspend fun getUserInfo(): Result<ProfileModel>
}
