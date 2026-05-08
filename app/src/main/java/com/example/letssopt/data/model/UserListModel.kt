package com.example.letssopt.data.model

data class UserListModel(
    val userList: List<UserItemModel>
)

data class UserItemModel (
    val id: String,
    val name: String,
    val part: String,
)
