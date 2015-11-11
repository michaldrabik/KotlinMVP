package com.michaldrabik.kotlintest.data.models

import android.os.Parcel
import android.os.Parcelable

data class Joke(val id: Int, val joke: String) : Parcelable {

  override fun writeToParcel(parcel: Parcel?, flags: Int) {
    parcel?.writeInt(id);
    parcel?.writeString(joke);
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object {
    @JvmField public val CREATOR: Parcelable.Creator<Joke> = object : Parcelable.Creator<Joke> {
      override fun createFromParcel(parcelIn: Parcel): Joke {
        return Joke(parcelIn.readInt(), parcelIn.readString());
      }

      override fun newArray(size: Int): Array<Joke> {
        return arrayOf();
      }
    }
  }

}
