package com.michaldrabik.kotlintest.ui.main

import com.michaldrabik.kotlintest.data.DataManager
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainPresenter @Inject constructor(val dataManager: DataManager) : BasePresenter<MainView>() {

  fun fetchJokes() {
    disposables.add(
        dataManager.getRandomJokes(100)
            .subscribeOn(io())
            .observeOn(mainThread())
            .subscribe(
                { onFetchJokesSuccess(it) },
                { onFetchJokesError(it) })
    )
  }

  fun onFetchJokesSuccess(jokes: List<Joke>) {
    view?.onFetchJokesSuccess(jokes)
  }

  fun onFetchJokesError(error: Throwable) {
    view?.onFetchJokesError(error)
  }

}
