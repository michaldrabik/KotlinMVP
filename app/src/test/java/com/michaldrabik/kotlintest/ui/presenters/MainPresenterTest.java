package com.michaldrabik.kotlintest.ui.presenters;

import com.michaldrabik.kotlintest.App;
import com.michaldrabik.kotlintest.BuildConfig;
import com.michaldrabik.kotlintest.MockModelsFactory;
import com.michaldrabik.kotlintest.data.api.Api;
import com.michaldrabik.kotlintest.data.model.Joke;
import com.michaldrabik.kotlintest.data.model.Response;
import com.michaldrabik.kotlintest.ui.main.MainPresenter;
import com.michaldrabik.kotlintest.ui.main.MainView;
import io.reactivex.Observable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = App.class, constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class MainPresenterTest {

  @Mock Api api;
  @Mock MainView activity;
  private MainPresenter presenter;

  @Before public void setup() {
    MockitoAnnotations.initMocks(this);
    presenter = new MainPresenter();
    presenter.bind(activity);
    presenter.setJokesApi(api);
  }

  @Test public void shouldFetchJokesWhenRequested() {
    when(api.fetchRandomJokes()).thenReturn(Observable.just(new Response<>("response", MockModelsFactory.createListOfJokes(20))));
    presenter.fetchJokes();
    verify(api).fetchRandomJokes();
  }

  @Test public void shouldNotifyViewWhenSuccess() {
    when(api.fetchRandomJokes()).thenReturn(Observable.just(new Response<>("response", MockModelsFactory.createListOfJokes(20))));
    presenter.fetchJokes();
    verify(activity).onFetchJokesSuccess(anyListOf(Joke.class));
  }

  @Test public void shouldNotifyViewWhenError() {
    when(api.fetchRandomJokes()).thenReturn(Observable.<Response<Joke>>error(new Throwable("Error")));
    presenter.fetchJokes();
    verify(activity).onFetchJokesError(Matchers.<Throwable>any());
  }
}
