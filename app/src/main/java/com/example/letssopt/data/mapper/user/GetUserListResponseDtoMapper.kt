package com.example.letssopt.data.mapper.user

import com.example.letssopt.data.model.UserItemModel
import com.example.letssopt.data.model.UserListModel
import com.example.letssopt.data.remote.dto.user.GetUserListResponseDto
import com.example.letssopt.data.remote.dto.user.UserDto


fun GetUserListResponseDto.toUserListModel() = UserListModel(
    userList = this.users.map { it.toUserItemModel() }
)


fun UserDto.toUserItemModel() = UserItemModel(
    id = this.id.toString(),
    name = this.name,
    part = this.part
)
