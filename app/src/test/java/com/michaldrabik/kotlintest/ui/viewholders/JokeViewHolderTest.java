package com.michaldrabik.kotlintest.ui.viewholders;

import android.app.Activity;
import android.widget.TextView;
import com.michaldrabik.kotlintest.App;
import com.michaldrabik.kotlintest.BuildConfig;
import com.michaldrabik.kotlintest.MockModelsFactory;
import com.michaldrabik.kotlintest.R;
import com.michaldrabik.kotlintest.data.model.Joke;
import com.michaldrabik.kotlintest.ui.main.list.JokeViewHolder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = App.class, constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class JokeViewHolderTest {

  private JokeViewHolder jokeViewHolder;
  private TextView idTextView;
  private TextView jokeTextView;

  @Before public void setup() {
    Activity activity = Robolectric.buildActivity(Activity.class).create().get();
    jokeViewHolder = new JokeViewHolder(activity);
    findViews();
  }

  private void findViews() {
    idTextView = (TextView) jokeViewHolder.findViewById(R.id.idText);
    jokeTextView = (TextView) jokeViewHolder.findViewById(R.id.jokeText);
  }

  @Test public void shouldSetDataProperly() {
    Joke joke = MockModelsFactory.createJoke(1, "Haha");
    jokeViewHolder.setData(joke);
    assertThat(idTextView.getText().toString(), is(String.valueOf(joke.getId())));
    assertThat(jokeTextView.getText().toString(), is(joke.getJoke()));
  }
}
