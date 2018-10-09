package com.michaldrabik.kotlintest.ui.presenters;

import com.michaldrabik.kotlintest.App;
import com.michaldrabik.kotlintest.BuildConfig;
import com.michaldrabik.kotlintest.MockModelsFactory;
import com.michaldrabik.kotlintest.data.DataManager;
import com.michaldrabik.kotlintest.data.model.Joke;
import com.michaldrabik.kotlintest.ui.main.MainPresenter;
import com.michaldrabik.kotlintest.ui.main.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import io.reactivex.Single;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = App.class, constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class MainPresenterTest {

  @Mock private MainView activity;
  @Mock private DataManager dataManager;

  private MainPresenter presenter;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    presenter = new MainPresenter(dataManager);
    presenter.bind(activity);
  }

  @Test
  public void shouldFetchJokesWhenRequested() {
    when(dataManager.loadRandomJokes(anyInt())).thenReturn(Single.just(MockModelsFactory.createListOfJokes(20)));
    presenter.fetchJokes();
    verify(dataManager).loadRandomJokes(anyInt());
  }

  @Test
  public void shouldNotifyViewWhenSuccess() {
    when(dataManager.loadRandomJokes(anyInt())).thenReturn(Single.just(MockModelsFactory.createListOfJokes(20)));
    presenter.fetchJokes();
    verify(activity).showJokes(anyListOf(Joke.class));
  }

  @Test
  public void shouldNotifyViewWhenError() {
    when(dataManager.loadRandomJokes(anyInt())).thenReturn(Single.<List<Joke>>error(new Throwable("Error")));
    presenter.fetchJokes();
    verify(activity).showError(Matchers.<Throwable>any());
  }
}
