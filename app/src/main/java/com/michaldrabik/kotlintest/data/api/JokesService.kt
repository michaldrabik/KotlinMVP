package com.michaldrabik.kotlintest.data.api

import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.data.models.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface JokesService {

  @GET("/jokes/random/50")
  fun fetchRandomJokes(): Observable<Response<Joke>>

}