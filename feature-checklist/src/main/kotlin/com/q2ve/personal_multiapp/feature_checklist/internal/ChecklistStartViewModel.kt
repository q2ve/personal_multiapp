package com.q2ve.personal_multiapp.feature_checklist.internal

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.q2ve.personal_multiapp.feature_checklist.di.DaggerFeatureChecklistComponent
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemSummary
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemTask

internal class ChecklistStartViewModel: ViewModel() {

	data class ViewState(
		val feedItems: List<AbstractChecklistItem>
	) {
		companion object {
			val EMPTY = ViewState(emptyList())
		}
	}

	val currentState = MutableLiveData<ViewState>().apply { value = ViewState.EMPTY }

	init {
		DaggerFeatureChecklistComponent.create().inject(this)
	}

	fun requestFeed(another: Boolean = false) {
		val items = if (!another) listOf(
			ItemSummary(123456789),
			ItemTask("Первая чек", true),
			ItemTask("Вторая", false),
			ItemTask("Третья", false),
			ItemTask("Четвертая чек", true),
			ItemTask("Пятая чек", true),
			ItemSummary(987654321),
		) else listOf(
			ItemSummary(1113456789),
			ItemTask("Первая чек", true),
			ItemTask("АБЫР АБЫР", false),
			ItemTask("Пятая чек", true),
			ItemTask("Четвертая чек", true),
			ItemTask("Третья", false),
			ItemSummary(987654321),
		)
		currentState.apply {
			value = value?.copy(feedItems = items)
		}
	}

	fun testDiffUtils() {
		Thread {
			run {
				Thread.sleep(2000)
				Handler(Looper.getMainLooper()).post { requestFeed(true) }
			}
		}.start()
	}
}
