package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass : ActivityMainBinding

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

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
            bindingClass.tvResult.text = ""
            var strMain = bindingClass.textV.text.toString()
            if(strMain=="")
            {
                strMain = "0"
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

            if (bindingClass.tvResult.text != "Ошибка")
            {
                if(Math.floor(result) == result)
                {
                    bindingClass.tvResult.text = "Результат: ${result.toInt()}"
                }
                else
                {
                    bindingClass.tvResult.text = "Результат: $result"
                }
            }
        }

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
        try
        {
            sum = arr[0].toDouble() / arr[1].toDouble()
        }
        catch (e: ArithmeticException)
        {
            bindingClass.tvResult.text = "Ошибка"
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