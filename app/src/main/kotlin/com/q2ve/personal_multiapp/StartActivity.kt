package com.q2ve.personal_multiapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.q2ve.personal_multiapp.feature_checklist.api.ChecklistStartFragment

class StartActivity: FragmentActivity() {
    private val buttonsList = listOf<Pair<String, () -> Unit>>(
        "Тудушник, лол" to ::openTodo,
        "Таймер" to ::openTimer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

    @SuppressLint("ResourceType")
    private fun getView(context: Context): View {
        fun getButton(text: String, onClickAction: () -> Unit): View {
            return TextView(context).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
                ).apply { weight = 1F }
                gravity = Gravity.CENTER
                this.text = text

                setOnClickListener { onClickAction.invoke() }
            }
        }
        val buttonsContainer = LinearLayout(context)
        buttonsContainer.apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.HORIZONTAL
            buttonsList.forEach { pair ->
                addView(getButton(text = pair.first, onClickAction = pair.second))
            }
        }
        val rootContainer = FrameLayout(context).apply {
            id = 1234
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            addView(buttonsContainer)
        }

        return rootContainer
    }

    @SuppressLint("ResourceType")
    private fun openTodo() {
        supportFragmentManager.beginTransaction().apply {
            add(
                1234,
                ChecklistStartFragment()
            )
            addToBackStack(null)
            commit()
        }
    }

    private fun openTimer() {
        Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show()
    }
}