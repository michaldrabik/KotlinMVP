package com.michaldrabik.kotlintest.injection.component

import com.michaldrabik.kotlintest.injection.scope.PerActivity
import com.michaldrabik.kotlintest.ui.main.MainActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent
interface ActivityComponent {

  fun inject(activity: MainActivity)

}