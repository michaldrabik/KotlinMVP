package com.michaldrabik.kotlintest.data.api

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface JokesService {

  @GET("/jokes/random/50")
  fun fetchRandomJokes(): Observable<Response<Joke>>

}