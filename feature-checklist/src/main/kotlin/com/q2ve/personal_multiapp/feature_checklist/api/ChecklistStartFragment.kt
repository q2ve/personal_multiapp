package com.q2ve.personal_multiapp.feature_checklist.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.q2ve.personal_multiapp.feature_checklist.databinding.FragmentChecklistStartBinding
import com.q2ve.personal_multiapp.feature_checklist.di.DaggerFeatureChecklistComponent
import com.q2ve.personal_multiapp.feature_checklist.internal.TestFeatureInternal
import dagger.Lazy
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Provider

class ChecklistStartFragment @Inject constructor(): Fragment() {

	@Inject
	internal lateinit var testFeature: Provider<TestFeatureInternal> // Singleton

	@Inject
	internal lateinit var testFeatureAnotherLink: Lazy<TestFeatureInternal> // Singleton

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		DaggerFeatureChecklistComponent.create().inject(this)
		if (testFeature.get() != testFeatureAnotherLink.get()) throw Exception("Лох")
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return FragmentChecklistStartBinding.inflate(inflater).apply {
			tessssst.text = testFeature.get().getSomeShit().toString()
		}.root
	}
}
