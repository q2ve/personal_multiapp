package com.q2ve.personal_multiapp.feature_checklist.internal.feed.items

import com.q2ve.personal_multiapp.feature_checklist.databinding.ItemTaskBinding
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.checklistDelegate

internal data class ItemSummary(
	val totalCount: Int,
): AbstractChecklistItem {
	override fun areItemsTheSame(anotherItem: AbstractChecklistItem): Boolean {
		return anotherItem == this
	}
	override fun areContentsTheSame(anotherItem: AbstractChecklistItem) =
		areItemsTheSame(anotherItem)

	companion object {
		fun delegate() = checklistDelegate<ItemTask, ItemTaskBinding>(ItemTaskBinding::inflate) {
			binding.itemTaskText.text = item.description
			binding.itemTaskCheckbox.isChecked = item.isChecked
		}
	}
}
