package com.michaldrabik.kotlintest.ui.main

import com.michaldrabik.kotlintest.data.DataManager
import com.michaldrabik.kotlintest.data.model.Joke
import com.michaldrabik.kotlintest.injection.scope.PerActivity
import com.michaldrabik.kotlintest.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(private val dataManager: DataManager) : BasePresenter<MainView>() {

  fun fetchJokes() {
    with(disposables) {
      clear()
      add(
        dataManager.loadRandomJokes(100)
          .subscribeOn(io())
          .observeOn(mainThread())
          .subscribe(
            { onFetchJokesSuccess(it) },
            { onFetchJokesError(it) })
      )
    }
  }

  fun onFetchJokesSuccess(jokes: List<Joke>) = view?.showJokes(jokes)

  fun onFetchJokesError(error: Throwable) = view?.showError(error)
}
