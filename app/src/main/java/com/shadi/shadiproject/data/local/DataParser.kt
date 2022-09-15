package com.shadi.shadiproject.data.local

import com.shadi.shadiproject.data.local.model.ShadiListModel

interface DataParser<T> {

    suspend fun parse(model: ShadiListModel) :List<T>
}