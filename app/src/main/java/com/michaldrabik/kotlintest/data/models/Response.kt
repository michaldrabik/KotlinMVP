package com.michaldrabik.kotlintest.data.models

data class Response<out T>(val type: String, val value: List<T>)
