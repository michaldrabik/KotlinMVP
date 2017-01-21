package com.michaldrabik.kotlintest;

import com.michaldrabik.kotlintest.data.model.Joke;
import java.util.ArrayList;
import java.util.List;

public class MockModelsFactory {

  public static Joke createJoke(int id, String text) {
    return new Joke(id, text);
  }

  public static List<Joke> createListOfJokes(int count) {
    List<Joke> jokes = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      jokes.add(new Joke(i, i + " Ha ha"));
    }
    return jokes;
  }

}
