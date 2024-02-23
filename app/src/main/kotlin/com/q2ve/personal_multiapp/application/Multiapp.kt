package com.q2ve.personal_multiapp.application

import android.app.Application
import com.q2ve.personal_multiapp.di.ApplicationComponent
import com.q2ve.personal_multiapp.di.DaggerApplicationComponent

internal class Multiapp: Application() {
	val applicationComponent: ApplicationComponent by lazy { DaggerApplicationComponent.create() }
}