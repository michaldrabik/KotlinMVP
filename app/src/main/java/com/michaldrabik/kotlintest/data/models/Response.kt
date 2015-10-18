package com.michaldrabik.kotlintest.data.models

data class Response<T>(val type: String, val value: List<T>)
