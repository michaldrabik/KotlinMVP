package com.michaldrabik.kotlintest.data

import com.michaldrabik.kotlintest.data.model.Joke
import io.reactivex.Single

interface DataManager {

  fun loadRandomJokes(count: Int): Single<List<Joke>>

}