package com.q2ve.personal_multiapp.feature_checklist.api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.q2ve.personal_multiapp.feature_checklist.databinding.FragmentChecklistStartBinding
import com.q2ve.personal_multiapp.feature_checklist.internal.TestFeatureInternal

class ChecklistStartFragment: Fragment() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return FragmentChecklistStartBinding.inflate(inflater).apply {
			tessssst.text = TestFeatureInternal().getSomeShit().toString()
		}.root
	}
}