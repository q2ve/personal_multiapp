package com.q2ve.personal_multiapp.di

import com.q2ve.personal_multiapp.start_activity.di.StartActivityComponent
import dagger.Component

@Component(modules = [ApplicationModule::class])
internal interface ApplicationComponent {
	fun getStartActivityComponent(): StartActivityComponent.Builder
}