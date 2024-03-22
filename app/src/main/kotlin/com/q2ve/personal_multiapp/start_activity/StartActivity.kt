package com.q2ve.personal_multiapp.start_activity

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
import com.q2ve.personal_multiapp.application.Multiapp
import com.q2ve.personal_multiapp.feature_checklist.api.ChecklistEntry

class StartActivity: FragmentActivity() {
    private val buttonsList = listOf<Pair<String, () -> Unit>>(
        "Тудушник, лол" to ::openTodo,
        "Таймер" to ::openTimer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as? Multiapp)?.apply {
            applicationComponent.getStartActivityComponent().build().injectStartActivity(this@StartActivity)
        } ?: {
            throw Exception("Application override class should be 'Multiapp'")
        } // TODO("А нужно ли это? Мб просто создавать компонент старт активити здесь, а не брать его у аппликэйшн, если от него ничего не нужно?")

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
                ChecklistEntry.getChecklistStartFragment()
            )
            addToBackStack(null)
            commit()
        }
    }

    private fun openTimer() {
        Toast.makeText(this, "Не готово", Toast.LENGTH_SHORT).show()
    }
}
