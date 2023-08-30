package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.calculator.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    lateinit var bindingClass : ActivitySettingsBinding
    var textSize = 22f

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val seek = bindingClass.seekBarSize

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(progress == 0)
                {
                    textSize = 10f
                }
                if(progress == 1)
                {
                    textSize = 12f
                }
                if(progress == 2)
                {
                    textSize = 14f
                }
                if(progress == 3)
                {
                    textSize = 16f
                }
                if(progress == 4)
                {
                    textSize = 18f
                }
                if(progress == 5)
                {
                    textSize = 20f
                }
                if(progress == 6)
                {
                    textSize = 22f
                }
                if(progress == 7)
                {
                    textSize = 24f
                }
                if(progress == 8)
                {
                    textSize = 26f
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    fun onClickSetting(view: View){
        val i = Intent()
        setResult(RESULT_OK,i)
        finish()
    }
    fun onClickSave(view: View){
        val i = Intent()
        i.putExtra("key1",textSize)
        setResult(RESULT_OK,i)
        finish()
    }
}