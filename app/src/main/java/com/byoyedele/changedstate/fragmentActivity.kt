package com.byoyedele.changedstate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.byoyedele.changedstate.ui.main.FragmentFragment

class fragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FragmentFragment.newInstance())
                .commitNow()
        }
    }
}