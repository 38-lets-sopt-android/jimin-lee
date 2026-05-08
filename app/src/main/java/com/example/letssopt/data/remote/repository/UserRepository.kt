package com.example.letssopt.data.remote.repository

import com.example.letssopt.data.model.ProfileModel
import com.example.letssopt.data.model.UserListModel

interface UserRepository {
    suspend fun getUserInfo(): Result<ProfileModel>
    suspend fun getUserList(): Result<UserListModel>
}
