package com.q2ve.personal_multiapp.application

import android.app.Application
import com.q2ve.personal_multiapp.application.di.ApplicationComponent
import com.q2ve.personal_multiapp.application.di.DaggerApplicationComponent

internal class Multiapp: Application() {
	val applicationComponent: ApplicationComponent by lazy { DaggerApplicationComponent.create() }
}