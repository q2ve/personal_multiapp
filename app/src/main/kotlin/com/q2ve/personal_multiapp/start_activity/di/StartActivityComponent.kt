package com.q2ve.personal_multiapp.start_activity.di

import com.q2ve.personal_multiapp.start_activity.StartActivity
import dagger.Subcomponent

@Subcomponent
internal interface StartActivityComponent {

	@Subcomponent.Builder
	interface Builder {
		fun build(): StartActivityComponent
	}

	fun injectStartActivity(startActivity: StartActivity)
}