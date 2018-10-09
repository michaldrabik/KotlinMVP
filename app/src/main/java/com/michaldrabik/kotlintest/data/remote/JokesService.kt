package com.michaldrabik.kotlintest.data.remote

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.model.Response
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JokesService {

  @GET("/jokes/random/{count}")
  fun fetchRandomJokes(@Path("count") count: Int): Single<Response<Joke>>

}