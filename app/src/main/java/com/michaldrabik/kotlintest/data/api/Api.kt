package com.michaldrabik.kotlintest.data.api

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.model.Response
import io.reactivex.Observable

interface Api {
  fun fetchRandomJokes(): Observable<Response<Joke>>
}