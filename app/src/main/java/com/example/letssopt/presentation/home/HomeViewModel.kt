package com.example.letssopt.presentation.home

import androidx.lifecycle.ViewModel
import com.example.letssopt.R
import com.example.letssopt.presentation.home.model.HomeContentItemModel
import com.example.letssopt.presentation.home.model.HomePartyItemModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeContract.State())
    val uiState = _uiState.asStateFlow()

    init {
        fetchNewContentItems()
        fetchHomeItems()
        fetchHomePartyItems()
    }

    private fun fetchNewContentItems() {
        _uiState.update {
            it.copy(
                newContentItems =
                    persistentListOf(
                        R.drawable.img_home_newcontent_1,
                        R.drawable.img_home_newcontent_2,
                        R.drawable.img_home_newcontent_3,
                    )
            )
        }
    }

    private fun fetchHomeItems() {
        _uiState.update {
            it.copy(
                homePartyItems =
                    persistentListOf(
                        HomePartyItemModel(1, R.drawable.img_home_party_1, "오늘 21:13에 시작", "# 왕과 사는 남자"),
                        HomePartyItemModel(2, R.drawable.img_home_party_2, "오늘 22:22에 시작", "# 파묘"),
                    )
            )
        }
    }

    private fun fetchHomePartyItems() {
        _uiState.update {
            it.copy(
                homeItems =
                    persistentListOf(
                        HomeContentItemModel(1, R.drawable.img_home_1),
                        HomeContentItemModel(2, R.drawable.img_home_2),
                        HomeContentItemModel(3, R.drawable.img_home_3),
                        HomeContentItemModel(4, R.drawable.img_home_1),
                        HomeContentItemModel(5, R.drawable.img_home_2),
                        HomeContentItemModel(6, R.drawable.img_home_3),
                    )
            )
        }
    }
}
