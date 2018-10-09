package com.michaldrabik.kotlintest.data

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.remote.JokesService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DataManagerImpl @Inject constructor(private val jokesService: JokesService) : DataManager {

  override fun loadRandomJokes(count: Int): Single<List<Joke>> {
    return jokesService
      .fetchRandomJokes(count)
      .flatMap { Single.just(it.value) }
  }

}