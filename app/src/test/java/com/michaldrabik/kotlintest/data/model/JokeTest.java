package com.michaldrabik.kotlintest.data.model;

import android.os.Parcel;
import com.michaldrabik.kotlintest.App;
import com.michaldrabik.kotlintest.BuildConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = App.class, constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml") public class JokeTest {

  /**
   * This test checks if Parcelable implementation is correct.
   */
  @Test public void testParcelable() {
    Joke joke = new Joke(1, "Haha");
    Parcel parcel = Parcel.obtain();
    joke.writeToParcel(parcel, 0);
    parcel.setDataPosition(0);
    Joke parceledJoke = Joke.CREATOR.createFromParcel(parcel);
    assertEquals(joke, parceledJoke);
  }
}

