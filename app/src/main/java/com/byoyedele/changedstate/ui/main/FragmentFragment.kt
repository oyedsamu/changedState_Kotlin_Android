package com.byoyedele.changedstate.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.byoyedele.changedstate.R

class FragmentFragment : AppCompatActivity() {

    companion object {
        fun newInstance() = FragmentFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        var fragmentmanager = supportFragmentManager

        var firstFragment = firstFrag()
        var secondFragment = secondFrag()
        var thirdFragment = thirdFrag()

        var counter = 1
        var arg = Bundle()

        var addFrag = findViewById<Button>(R.id.add_fragment)
        var remFrag = findViewById<Button>(R.id.remove_fragment)

        addFrag.setOnClickListener {
            var processor = fragmentmanager.beginTransaction()
                when(counter){
                    1 -> processor.add(R.id.frame, firstFragment).addToBackSTack(null).commit()
                    2 -> processor.add(R.id.frame, secondFragment).addToBackSTack(null).commit()
                    3 -> processor.add(R.id.frame, thirdFragment).addToBackSTack(null).commit()
                }

            arg.putInt()
        }

    }



}