package com.q2ve.personal_multiapp.feature_checklist.internal

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.q2ve.personal_multiapp.feature_checklist.di.DaggerFeatureChecklistComponent
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.AbstractChecklistItem
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemSummary
import com.q2ve.personal_multiapp.feature_checklist.internal.feed.items.ItemTask
import com.q2ve.personal_multiapp.repository_tasks.api.RepositoryTasks
import dagger.Reusable
import javax.inject.Inject

internal class ChecklistStartViewModel: ViewModel() {

	data class ViewState(
		val feedItems: List<AbstractChecklistItem>
	) {
		companion object {
			val EMPTY = ViewState(emptyList())
		}
	}

	val currentState = MutableLiveData<ViewState>().apply { value = ViewState.EMPTY }

	@Inject
	@Reusable
	lateinit var repository: RepositoryTasks

	init {
		DaggerFeatureChecklistComponent.create().inject(this)
	}

	fun requestFeed() {
		val items = listOf(
			ItemSummary(123456789),
			ItemTask("Понюхать бебру", true),
			ItemSummary(987654321),
		)
		currentState.apply {
			value = value?.copy(feedItems = items)
		}
	}

	fun testDiffUtilsAndDb() {
		Thread {
			run {
				Thread.sleep(2000)
				Handler(Looper.getMainLooper()).post {
					repository.getAll().observeForever { list ->
						currentState.apply {
							value = value?.copy(feedItems = list.map { ItemTask(it.description, it.isChecked) })
						}
					}
				}
			}
		}.start()
	}
}
