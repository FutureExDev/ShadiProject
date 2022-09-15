package com.shadi.shadiproject.presentation.shadi_list

import com.shadi.shadiproject.data.local.entity.ShadiListEntity

data class ShadiListState(
   val isLoading: Boolean = false,
   val shadiListEntity: List<ShadiListEntity> = emptyList()
)
