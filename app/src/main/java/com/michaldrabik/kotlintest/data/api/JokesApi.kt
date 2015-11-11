package com.michaldrabik.kotlintest.data.api

import com.michaldrabik.kotlintest.BuildConfig
import com.michaldrabik.kotlintest.data.models.Joke
import com.michaldrabik.kotlintest.data.models.Response
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

object JokesApi : Api {

  private val jokesService = buildRetrofit().create(JokesService::class.java)

  fun buildRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BuildConfig.API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
      .build()

  override fun fetchRandomJokes(): Observable<Response<Joke>> {
    return jokesService.fetchRandomJokes()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }

}