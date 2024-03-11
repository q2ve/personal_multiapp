package com.q2ve.personal_multiapp.feature_checklist.api

import androidx.fragment.app.Fragment
import com.q2ve.personal_multiapp.feature_checklist.internal.ChecklistStartFragment

interface ChecklistEntry {
	companion object {
		fun getChecklistStartFragment(): Fragment = ChecklistStartFragment()
	}
}