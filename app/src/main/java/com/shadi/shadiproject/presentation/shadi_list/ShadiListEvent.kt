package com.shadi.shadiproject.presentation.shadi_list

import com.shadi.shadiproject.data.local.entity.ShadiListEntity

sealed class ShadiListEvent {

    class AcceptRequest(val shadiListEntity: ShadiListEntity) : ShadiListEvent()
    class RejectRequest(val shadiListEntity: ShadiListEntity) : ShadiListEvent()
}