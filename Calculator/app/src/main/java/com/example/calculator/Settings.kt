package com.example.calculator

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Toast
import com.example.calculator.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    lateinit var bindingClass : ActivitySettingsBinding
    var textSize = 16f
    var textColor = Color.parseColor("#FFFFFFFF")
    var textColorId = 0
    var progres = 0

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val seek = bindingClass.seekBarSize
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        progres = sharedPref.getInt("seekBarProgress", 0)
        textSize = sharedPref.getFloat("textVSize",16f)
        textColorId = sharedPref.getInt("textVColorId",0)

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

        val colors = arrayOf("Белый","Черный","Красный", "Оранжевый", "Желтый", "Зеленый", "Голубой", "Синий", "Фиолетовый")
        val spinner: Spinner = bindingClass.spinnerColors
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.setSelection(textColorId)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val color = parent.getItemAtPosition(position).toString()
                when(color) {
                    "Белый" -> {
                        textColor = Color.parseColor("#FFFFFFFF")
                        textColorId = 0
                    }
                    "Черный" -> {
                        textColor = Color.parseColor("#FF000000")
                        textColorId = 1
                    }
                    "Красный" -> {
                        textColor = Color.parseColor("#B00020")
                        textColorId = 2
                    }
                    "Оранжевый" -> {
                        textColor = Color.parseColor("#FFFF8800")
                        textColorId = 3
                    }
                    "Желтый" -> {
                        textColor = Color.parseColor("#FFFFBB33")
                        textColorId = 4
                    }
                    "Зеленый" -> {
                        textColor = Color.parseColor("#FF669900")
                        textColorId = 5
                    }
                    "Голубой" -> {
                        textColor = Color.parseColor("#219BCC")
                        textColorId = 6
                    }
                    "Синий" -> {
                        textColor = Color.parseColor("#3700B3")
                        textColorId = 7
                    }
                    "Фиолетовый" -> {
                        textColor = Color.parseColor("#6200EE")
                        textColorId = 8
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

    }

    override fun onPause() {
        super.onPause()
    }

    fun onClickSetting(view: View){
        finish()
    }
    fun onClickSave(view: View){
        val i = Intent()
        i.putExtra("keySize",textSize)
        i.putExtra("keyColor",textColor)
        setResult(RESULT_OK,i)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putInt("seekBarProgress", progres)
            putInt("textVColorId", textColorId)
            putFloat("textVSize",textSize)
            apply()
        }

        Toast.makeText(this, R.string.bSave, Toast.LENGTH_SHORT).show()

        finish()
    }
}