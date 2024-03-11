package com.q2ve.personal_multiapp.feature_checklist.internal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.q2ve.personal_multiapp.feature_checklist.databinding.FragmentChecklistStartBinding
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.ChecklistDiffUtilCallback
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemSummary
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemTask

internal class ChecklistStartFragment: Fragment() {

	private val viewModel: ChecklistStartViewModel by viewModels() //lazy

	private var binding: FragmentChecklistStartBinding? = null

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		val binding = FragmentChecklistStartBinding.inflate(inflater)

		val adapter = AsyncListDifferDelegationAdapter(
			ChecklistDiffUtilCallback(),
			ItemSummary.delegate(),
			ItemTask.delegate(),
//			ItemTaskComplex.delegate(),
		)

		binding.feedRecycler.adapter = adapter
		viewModel.currentState.observe(viewLifecycleOwner) { adapter.items = it.feedItems }
		viewModel.requestFeed()
		viewModel.testDiffUtils()

		return binding.root
	}

	override fun onDestroyView() {
		binding = null
		super.onDestroyView()
	}
}
