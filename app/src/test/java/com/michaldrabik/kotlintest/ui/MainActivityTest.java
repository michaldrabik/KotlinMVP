package com.michaldrabik.kotlintest.ui;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.michaldrabik.kotlintest.App;
import com.michaldrabik.kotlintest.BuildConfig;
import com.michaldrabik.kotlintest.MockModelsFactory;
import com.michaldrabik.kotlintest.R;
import com.michaldrabik.kotlintest.data.DataManager;
import com.michaldrabik.kotlintest.ui.main.MainActivity;
import com.michaldrabik.kotlintest.ui.main.MainPresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = App.class, constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class MainActivityTest {

  @Mock DataManager dataManager;

  private MainActivity activity;
  private MainPresenter presenter;
  private ProgressBar progressBar;
  private Toolbar toolbar;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    activity = Robolectric.buildActivity(MainActivity.class).create().get();
    presenter = new MainPresenter(dataManager);
    presenter.bind(activity);
    findViews();
  }

  private void findViews() {
    progressBar = (ProgressBar) activity.findViewById(R.id.progressBar);
    toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
  }

  @Test
  public void toolbarShouldBePresentAndVisible() {
    assertThat(toolbar, is(notNullValue()));
    assertThat(toolbar.getVisibility(), is(View.VISIBLE));
  }

  @Test
  public void toolbarShouldHaveProperTitle() {
    TextView toolbarTitle = (TextView) activity.findViewById(R.id.toolbarTitle);
    assertThat(toolbarTitle.getText().toString(), is("Chuck Norris Jokes"));
  }

  @Test
  public void progressBarShouldBeVisible() {
    assertThat(progressBar.getVisibility(), is(View.VISIBLE));
  }

  @Test
  public void shouldHideProgressWhenPresenterNotifiesSuccess() {
    presenter.onFetchJokesSuccess(MockModelsFactory.createListOfJokes(50));
    assertThat(progressBar.getVisibility(), is(View.GONE));
  }

  @Test
  public void shouldLoadJokesWhenPresenterNotifiesSuccess() {
    presenter.onFetchJokesSuccess(MockModelsFactory.createListOfJokes(50));
    assertThat(activity.getAdapter().getItemCount(), greaterThan(0));
  }

  @Test
  public void shouldHideProgressWhenPresenterNotifiesError() {
    presenter.onFetchJokesError(new Throwable("Error"));
    assertThat(progressBar.getVisibility(), is(View.GONE));
  }

  @Test
  public void shouldShowErrorToastWhenPresenterNotifiesError() {
    presenter.onFetchJokesError(new Throwable("Error"));
    assertThat(ShadowToast.shownToastCount(), is(1));
  }
}
