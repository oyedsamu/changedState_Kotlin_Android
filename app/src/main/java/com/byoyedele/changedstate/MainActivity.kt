package com.byoyedele.changedstate

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var portraitCount = 0
    var landscapeCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.text_current_state.text = "onCreate"
    }

    override fun onStart() {
        super.onStart()
        this.text_current_state.text = "onStart"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val orient = this.resources.configuration.orientation
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState?.run {
            landscapeCount = getInt(forLandscape)
            portraitCount = getInt(forPortrait)
        }
        if(orient == Configuration.ORIENTATION_PORTRAIT) {
            ++portraitCount
            this.current_orientation.text = "The current orientation is Portrait"
            this.orientation_display.text = "Portrait Count: $portraitCount"
        } else
            if (orient == Configuration.ORIENTATION_LANDSCAPE){
                ++landscapeCount
                this.current_orientation.text = "The current orientation is Landscape"
                this.orientation_display.text = "Landscape Count: $landscapeCount"
            }

    }

    override fun onResume() {
        super.onResume()
        this.text_current_state.text = "onResume"
    }

    override fun onPause() {
        super.onPause()
        this.text_current_state.text = "onPause"
    }

    override fun onStop() {
        super.onStop()
        this.text_current_state.text = "onStop"

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.run {
            putInt(forLandscape, landscapeCount)
            putInt(forPortrait, portraitCount)
        }
    }

    companion object{
        val forLandscape = "landscapeCount"
        val forPortrait = "portraitCount"

    }

    override fun onDestroy() {
        super.onDestroy()
        this.text_current_state.text = "onDestroy"
    }

    override fun onRestart() {
        super.onRestart()
        this.text_current_state.text = "onRestart"
    }
}