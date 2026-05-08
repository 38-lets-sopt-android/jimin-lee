package com.example.letssopt.presentation.user

import com.example.letssopt.data.model.UserItemModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

interface UserContract {
    data class State(
        val userList: ImmutableList<UserItemModel> = persistentListOf(),
    )
}
