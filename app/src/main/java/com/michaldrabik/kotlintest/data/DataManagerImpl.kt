package com.michaldrabik.kotlintest.data

import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.data.remote.JokesService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManagerImpl @Inject constructor(val jokesService: JokesService) : DataManager {

  override fun getRandomJokes(count: Int): Observable<List<Joke>> {
    return jokesService
        .fetchRandomJokes(count)
        .flatMap { Observable.just(it.value) }
  }

}