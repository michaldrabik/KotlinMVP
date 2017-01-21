package com.michaldrabik.kotlintest.data

import com.michaldrabik.kotlintest.data.model.Joke
import io.reactivex.Observable

interface DataManager {

  fun getRandomJokes(count: Int): Observable<List<Joke>>

}