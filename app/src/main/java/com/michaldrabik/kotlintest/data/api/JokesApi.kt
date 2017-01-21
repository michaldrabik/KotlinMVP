package com.michaldrabik.kotlintest.data.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.michaldrabik.kotlintest.BuildConfig
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.model.Response
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JokesApi : Api {

  private val jokesService = buildRetrofit().create(JokesService::class.java)

  fun buildRetrofit(): Retrofit = Retrofit.Builder().baseUrl(BuildConfig.API_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()

  override fun fetchRandomJokes(): Observable<Response<Joke>> {
    return jokesService.fetchRandomJokes()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }

}