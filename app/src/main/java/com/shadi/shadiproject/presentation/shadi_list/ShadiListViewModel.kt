package com.shadi.shadiproject.presentation.shadi_list


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shadi.shadiproject.domain.repository.ShadiRepository
import com.shadi.shadiproject.retantions.ShadiStatus
import com.shadi.shadiproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShadiListViewModel @Inject constructor(
    private val repository: ShadiRepository
) : ViewModel() {

    var shadiState by mutableStateOf(ShadiListState())

    init {
        getShadiList("10")
    }

    fun onEvent(event: ShadiListEvent) {
        when (event) {
            is ShadiListEvent.AcceptRequest -> {
                viewModelScope.launch {
                    repository.updateShadiModel(event.shadiListEntity.copy(status = ShadiStatus.ACCEPT.type))
                    getShadiList("")
                }

            }
            is ShadiListEvent.RejectRequest -> {
                viewModelScope.launch {
                    repository.updateShadiModel(event.shadiListEntity.copy(status = ShadiStatus.REJECT.type))
                    getShadiList("")
                }
            }

        }
    }

    private fun getShadiList(result: String?) {
        viewModelScope.launch {
            repository.getListShadi(result)
                .collect { response ->
                    when (response) {

                        is Resource.Loading -> {
                            shadiState = shadiState.copy(isLoading = response.isLoading)
                        }
                        is Resource.Success -> {
                            response.data?.let {
                                shadiState = shadiState.copy(shadiListEntity = it)
                            }
                        }
                        is Resource.Error -> {

                        }
                    }
                }

        }
    }
}