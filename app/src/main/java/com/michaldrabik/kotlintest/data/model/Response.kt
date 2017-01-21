package com.michaldrabik.kotlintest.data.model

data class Response<out T>(val type: String, val value: List<T>)
