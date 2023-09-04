package com.example.calculator

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.toColorInt
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    private var launcherSetting: ActivityResultLauncher<Intent>? = null
    lateinit var bindingClass : ActivityMainBinding
    var err = false
    var textVSize = 16f
    var textVColor = Color.parseColor("#FFFFFFFF")
    var textResultVColor = Color.parseColor("#FFFFFFFF")


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        bindingClass.textV.textSize = sharedPref.getFloat("textVSize",16f)
        textVColor = sharedPref.getInt("textVColor",Color.parseColor("#FFFFFFFF"))
        textResultVColor = sharedPref.getInt("textResultVColor",Color.parseColor("#FFFFFFFF"))
        bindingClass.textV.setTextColor(textVColor)
        bindingClass.tvResult.setTextColor(textResultVColor)

        launcherSetting = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->

            if(result.resultCode == RESULT_OK)
            {
                var textSize = result.data?.getFloatExtra("keySize",16f)
                var textColor = result.data?.getIntExtra("keyColor",Color.parseColor("#FFFFFFFF"))
                var textResultColor = result.data?.getIntExtra("keyResultColor",Color.parseColor("#FFFFFFFF"))
                if(textSize != null)
                {
                    bindingClass.textV.textSize = textSize
                    textVSize = textSize
                }
                if(textColor != null)
                {
                    bindingClass.textV.setTextColor(textColor)
                    textVColor = textColor
                }
                if(textResultColor != null)
                {
                    bindingClass.tvResult.setTextColor(textResultColor)
                    textResultVColor = textResultColor
                }
            }
        }

        bindingClass.b0.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "0"
        }
        bindingClass.b1.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "1"
        }
        bindingClass.b2.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "2"
        }
        bindingClass.b3.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "3"
        }
        bindingClass.b4.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "4"
        }
        bindingClass.b5.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "5"
        }
        bindingClass.b6.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "6"
        }
        bindingClass.b7.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "7"
        }
        bindingClass.b8.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "8"
        }
        bindingClass.b9.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "9"
        }
        bindingClass.bBracket1.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "("
        }
        bindingClass.bBracket2.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + ")"
        }
        bindingClass.bPlus.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "+"
        }
        bindingClass.bMinus.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "-"
        }
        bindingClass.bMultiplication.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "*"
        }
        bindingClass.bDivision.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "/"
        }
        bindingClass.bDel.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.dropLast(1)
        }
        bindingClass.bAc.setOnClickListener {
            bindingClass.textV.text = ""
        }
        bindingClass.bComma.setOnClickListener {
            bindingClass.textV.text = bindingClass.textV.text.toString() + "."
        }

        bindingClass.bResult.setOnClickListener {
            err = false
            bindingClass.tvResult.text = ""
            var strMain = bindingClass.textV.text.toString()

            if(strMain=="")
            {
                strMain = "0"
            }
            if((strMain == "+" || strMain == "-" || strMain == "/" || strMain == "*" || strMain == ".") || Regex("[-+/*.]{2,}").containsMatchIn(strMain))
            {
                strMain = "0"
                err = true
            }
            if("+-/*".contains(strMain[0]))
            {
                strMain = strMain.drop(1)
            }
            if("+-/*".contains(strMain[strMain.lastIndex]))
            {
                strMain = strMain.dropLast(1)
            }

            var str : String = ""
            var i = 0

            while (i<strMain.length)
            {
                if(strMain[i]=='(')
                {
                    if(startBracket(strMain,i) < endBracket(strMain,i))
                    {
                        i = startBracket(strMain,i)
                        if(startBracket(strMain,i) < endBracket(strMain,i))
                        {
                            i = startBracket(strMain,i)
                            if(startBracket(strMain,i) < endBracket(strMain,i))
                            {
                                i = startBracket(strMain,i)
                                if(startBracket(strMain,i) < endBracket(strMain,i))
                                {
                                    i = startBracket(strMain,i)
                                    if(startBracket(strMain,i) < endBracket(strMain,i))
                                    {
                                        i = startBracket(strMain,i)
                                        if(startBracket(strMain,i) < endBracket(strMain,i))
                                        {
                                            i = startBracket(strMain,i)
                                            if(startBracket(strMain,i) < endBracket(strMain,i))
                                            {
                                                i = startBracket(strMain,i)
                                                if(startBracket(strMain,i) < endBracket(strMain,i))
                                                {
                                                    i = startBracket(strMain,i)

                                                }
                                                else
                                                {
                                                    str = strMain.substring(i+1,endBracket(strMain,i))
                                                    strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                                    i = 0
                                                }

                                            }
                                            else
                                            {
                                                str = strMain.substring(i+1,endBracket(strMain,i))
                                                strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                                i = 0
                                            }

                                        }
                                        else
                                        {
                                            str = strMain.substring(i+1,endBracket(strMain,i))
                                            strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                            i = 0
                                        }

                                    }
                                    else
                                    {
                                        str = strMain.substring(i+1,endBracket(strMain,i))
                                        strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                        i = 0
                                    }

                                }
                                else
                                {
                                    str = strMain.substring(i+1,endBracket(strMain,i))
                                    strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                    i = 0
                                }

                            }
                            else
                            {
                                str = strMain.substring(i+1,endBracket(strMain,i))
                                strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                                i = 0
                            }
                        }
                        else
                        {
                            str = strMain.substring(i+1,endBracket(strMain,i))
                            strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                            i = 0
                        }
                    }
                    else
                    {
                        str = strMain.substring(i+1,endBracket(strMain,i))
                        strMain = strMain.replaceFirst('('+str+')',Logic(str).toString())
                        i = 0
                    }
                }

                i++
            }

            var result = Logic(strMain)

            if(err == true)
            {
                bindingClass.tvResult.text = "Ошибка"
            }
            else
            {
                if(Math.floor(result) == result)
                {
                    bindingClass.tvResult.text = getString(R.string.result) + result.toInt().toString()
                }
                else
                {
                    bindingClass.tvResult.text = getString(R.string.result) + result.toString()
                }
            }

        }

    }

    override fun onPause() {
        super.onPause()
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putFloat("textVSize",textVSize)
            putInt("textVColor",textVColor)
            putInt("textResultVColor",textResultVColor)
            apply()
        }
    }

    fun onClickSetting(view: View)
    {
        launcherSetting?.launch(Intent(this,Settings::class.java))
    }

    fun Logic(strTransmitted: String):Double
    {
        var str = strTransmitted
        var str1 : String = ""
        var result = 0.0
        var count = 0
        var i = 0

        while (i <str.length-1)
        {
            if(str[i]=='*')
            {
                str += "+"
                var start = Start(str,i)
                var end = End(str,i)
                str1 = str.substring(start+1, end)
                result = Multiplication(str1)
                str = str.replaceFirst(str1,result.toString())
                str = str.dropLast(1)
                i = 0
            }

            if(str[i]=='/')
            {
                str += "+"
                var start = Start(str,i)
                var end = End(str,i)
                str1 = str.substring(start+1, end)
                result = Division(str1)
                str = str.replaceFirst(str1,result.toString())
                str = str.dropLast(1)
                i = 0
            }

            i++
        }

        i = 0
        result = 0.0

        while (i <str.length-1)
        {
            if(str[i]=='+')
            {
                if(count == 0)
                {
                    str += "+"
                    var end = End(str,i)
                    str1 = str.substring(0,end)
                    result += Sum(str1)
                    str = str.dropLast(1)
                }
                if(count != 0)
                {

                    str += "+"
                    var start = Start(str,i+1)
                    var end = End(str,i)
                    str1 = str.substring(start, end)
                    result += Summ(str1)
                    str = str.dropLast(1)
                }
                count++
            }

            if(str[i]=='-')
            {
                if(count == 0)
                {
                    str += "+"
                    var end = End(str,i)
                    str1 = str.substring(0,end)
                    result += Minus(str1)
                    str = str.dropLast(1)
                }
                if(count != 0)
                {
                    str += "+"
                    var start = Start(str,i+1)
                    var end = End(str,i)
                    str1 = str.substring(start, end)
                    result += Minuss(str1)
                    str = str.dropLast(1)
                }
                count++
            }

            i++
        }

        if(count == 0)
        {
            result = str.toDouble()
        }

        return result
    }

    fun Sum(str1: String): Double
    {
        var sum = 0.0
        val arr = str1.split('+')
        for (number in arr) {
            sum += number.toDouble()
        }

        return sum
    }

    fun Summ(str1: String): Double
    {
        var sum = str1.toDouble()

        return sum
    }

    fun Minus(str1: String): Double
    {
        var sum = 0.0
        val arr = str1.split('-')
        sum = arr[0].toDouble() - arr[1].toDouble()

        return sum
    }

    fun Minuss(str1: String): Double
    {
        var sum = str1.toDouble()

        return sum
    }

    fun Multiplication(str1: String): Double
    {
        var sum = 0.0
        val arr = str1.split('*')
        sum = arr[0].toDouble() * arr[1].toDouble()

        return sum
    }

    fun Division(str1: String): Double
    {
        var sum = 0.0
        val arr = str1.split('/')

        if(arr[1].toDouble() == 0.0)
        {
            err = true
        }
        else
        {
            sum = arr[0].toDouble() / arr[1].toDouble()
        }

        return sum
    }

    fun Start(str: String, i:Int): Int
    {
        var start = max(max(str.lastIndexOf('+',i-1),str.lastIndexOf('-',i-1)),max(str.lastIndexOf('*',i-1),str.lastIndexOf('/',i-1)))

        return start
    }

    fun End(str: String, i:Int): Int
    {
        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))

        return end
    }

    fun startBracket(strMain: String, i:Int): Int
    {
        var start = strMain.indexOf('(',i+1).takeIf { it != -1 } ?: 1000
        return start
    }
    fun endBracket(strMain: String, i:Int): Int
    {
        var end = strMain.indexOf(')',i+1)
        return end
    }

}