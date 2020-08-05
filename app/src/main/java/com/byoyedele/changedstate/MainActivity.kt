package com.byoyedele.changedstate

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var portraitCount = 0
    var landscapeCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var run = Runnable {
            this.text_current_state.text = "onCreate"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)

        var imp2 = findViewById<Button>(R.id.implementation_2)
        imp2.setOnClickListener{
            var intent = Intent(this, fragmentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        var run = Runnable {
            this.text_current_state.text = "onStart"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)

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
        var run = Runnable {
            this.text_current_state.text = "onResume"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)
    }

    override fun onPause() {
        super.onPause()
        var run = Runnable {
            this.text_current_state.text = "onPause"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)
    }

    override fun onStop() {
        super.onStop()
        var run = Runnable {
            this.text_current_state.text = "onStop"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)

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
        var run = Runnable {
            this.text_current_state.text = "onDestroy"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)
    }

    override fun onRestart() {
        super.onRestart()
        var run = Runnable {
            this.text_current_state.text = "onRestart"
        }
        var hand = Handler()
        hand.postDelayed(run, 1200)

    }

}