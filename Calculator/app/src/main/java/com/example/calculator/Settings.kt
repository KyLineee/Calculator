package com.example.calculator

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.calculator.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    lateinit var bindingClass : ActivitySettingsBinding
    var textSize = 16f
    var progres = 0

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val seek = bindingClass.seekBarSize

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        progres = sharedPref.getInt("seekBarProgress", 0)
        textSize = sharedPref.getFloat("textVSize",16f)
        bindingClass.textVSize.text = textSize.toString()
        seek.progress = progres

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(progress == 0)
                {
                    textSize = 10f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 1)
                {
                    textSize = 12f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 2)
                {
                    textSize = 14f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 3)
                {
                    textSize = 16f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 4)
                {
                    textSize = 18f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 5)
                {
                    textSize = 20f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 6)
                {
                    textSize = 22f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 7)
                {
                    textSize = 24f
                    bindingClass.textVSize.text = textSize.toString()
                }
                if(progress == 8)
                {
                    textSize = 26f
                    bindingClass.textVSize.text = textSize.toString()
                }
                progres = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun onPause() {
        super.onPause()

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putInt("seekBarProgress", progres)
            putFloat("textVSize",textSize)
            apply()
        }
    }

    fun onClickSetting(view: View){
        finish()
    }
    fun onClickSave(view: View){
        val i = Intent()
        i.putExtra("key1",textSize)
        setResult(RESULT_OK,i)
        finish()
    }
}