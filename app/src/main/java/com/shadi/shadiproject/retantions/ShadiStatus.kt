package com.shadi.shadiproject.retantions

enum class ShadiStatus(var type: Int) {
    DEFAULT(0),
    ACCEPT(1),
    REJECT(2);

    companion object {
        fun getShadiStatus(type: Int) = values().first { it.type == type }
    }

}