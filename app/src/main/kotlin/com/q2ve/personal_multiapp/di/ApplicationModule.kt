package com.q2ve.personal_multiapp.di

import com.q2ve.personal_multiapp.start_activity.di.StartActivityComponent
import dagger.Module

@Module(subcomponents = [StartActivityComponent::class])
internal interface ApplicationModule