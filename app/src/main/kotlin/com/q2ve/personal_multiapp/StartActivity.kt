package com.q2ve.personal_multiapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class StartActivity: Activity() {
    private val buttonsList = listOf<Pair<String, () -> Unit>>(
        "Тудушник, лол" to ::openTodo,
        "Таймер" to ::openTimer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getView(this))
    }

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
        val rootContainer = LinearLayout(context)
        rootContainer.apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            orientation = LinearLayout.HORIZONTAL
            buttonsList.forEach { pair ->
                addView(getButton(text = pair.first, onClickAction = pair.second))
            }
        }

        return rootContainer
    }

    private fun openTodo() {
        Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show()
    }

    private fun openTimer() {
        Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show()
    }
}