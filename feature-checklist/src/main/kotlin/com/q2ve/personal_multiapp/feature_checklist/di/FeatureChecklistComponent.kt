package com.q2ve.personal_multiapp.feature_checklist.di

import com.q2ve.personal_multiapp.feature_checklist.api.ChecklistStartFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [FeatureChecklistModule::class])
@Singleton
internal interface FeatureChecklistComponent {
	fun inject(checklistStartFragment: ChecklistStartFragment)
}
