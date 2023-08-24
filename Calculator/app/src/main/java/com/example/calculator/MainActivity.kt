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

        bindingClass.b1.setOnClickListener {
            var str = bindingClass.edText1.text.toString()
            var str1 : String = ""
            var result = 0
            var count = 0
            var i = 0

            while (i <str.length-1)
            {
                if(str[i]=='*')
                {
                    if(count == 0)
                    {

                        str += "-+"
                        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))
                        str1 = str.substring(0, end)
                        result = Multiplication(str1)
                        str = str.replaceFirst(str1,result.toString())
                        str = str.dropLast(2)
                        i = 0
                    }
                    if(count != 0)
                    {
                        str += "-+"
                        var start = max(max(str.lastIndexOf('+',i-1),str.lastIndexOf('-',i-1)),max(str.lastIndexOf('*',i-1),str.lastIndexOf('/',i-1)))
                        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))
                        str1 = str.substring(start+1, end)
                        result = Multiplication(str1)
                        str = str.replaceFirst(str1,result.toString())
                        str = str.dropLast(2)
                        i = 0
                    }

                    count++
                }

                if(str[i]=='/')
                {
                    if(count == 0)
                    {
                        str += "-+"
                        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))
                        str1 = str.substring(0, end)
                        result = Division(str1)
                        str = str.replaceFirst(str1,result.toString())
                        str = str.dropLast(2)
                        i = 0
                    }
                    if(count != 0)
                    {
                        str += "-+"
                        var start = max(max(str.lastIndexOf('+',i-1),str.lastIndexOf('-',i-1)),max(str.lastIndexOf('*',i-1),str.lastIndexOf('/',i-1)))
                        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))
                        str1 = str.substring(start+1, end)
                        result = Division(str1)
                        str = str.replaceFirst(str1,result.toString())
                        str = str.dropLast(2)
                        i = 0
                    }

                    count++
                }

                i++
            }

            i = 0
            count = 0
            result = 0

            while (i <str.length-1)
            {
                if(str[i]=='+')
                {
                    if(count == 0)
                    {
                        str += "-+"
                        var end = min(min(str.indexOf('+',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('-',i+1).takeIf { it != -1 } ?: 1000),min(str.indexOf('*',i+1).takeIf { it != -1 } ?: 1000,str.indexOf('/',i+1).takeIf { it != -1 } ?: 1000))
                        str1 = str.substring(0, min(str.indexOf('+',i+1),str.indexOf('-',i+1)) )
                        result += Sum(str1)
                        str = str.dropLast(2)
                    }
                    if(count != 0)
                    {

                        str += "-+"
                        str1 = str.substring(i+1)
                        var end = min(min(str1.indexOf('+').takeIf { it != -1 } ?: 1000,str1.indexOf('-').takeIf { it != -1 } ?: 1000),min(str1.indexOf('*').takeIf { it != -1 } ?: 1000,str1.indexOf('/').takeIf { it != -1 } ?: 1000))
                        str1 = str1.substring(0, end)
                        result += Summ(str1)
                        str = str.dropLast(2)
                    }
                    count++
                }

                if(str[i]=='-')
                {
                    if(count == 0)
                    {
                        str += "+-"
                        str1 = str.substring(0, min(str.indexOf('-',i+1),str.indexOf('+',i+1)) )
                        result += Minus(str1)
                        str = str.dropLast(2)
                    }
                    if(count != 0)
                    {
                        str += "+-"
                        str1 = str.substring(i+1)
                        var end = min(min(str1.indexOf('+').takeIf { it != -1 } ?: 1000,str1.indexOf('-').takeIf { it != -1 } ?: 1000),min(str1.indexOf('*').takeIf { it != -1 } ?: 1000,str1.indexOf('/').takeIf { it != -1 } ?: 1000))
                        str1 = str1.substring(0, end)
                        result += Minuss(str1)
                        str = str.dropLast(2)
                    }
                    count++
                }

                i++
            }

            if(count == 0)
            {
                result = str.toInt()
            }

            bindingClass.tvResult.text = "Результат: $result"
        }

    }

    fun Sum(str1: String): Int
    {
        var sum = 0
        val arr = str1.split('+')
        for (number in arr) {
            sum += number.toInt()
        }

        return sum
    }

    fun Summ(str1: String): Int
    {
        var sum = str1.toInt()

        return sum
    }

    fun Minus(str1: String): Int
    {
        var sum = 0
        val arr = str1.split('-')
        sum = arr[0].toInt() - arr[1].toInt()

        return sum
    }

    fun Minuss(str1: String): Int
    {
        var sum = 0
        sum -= str1.toInt()

        return sum
    }

    fun Multiplication(str1: String): Int
    {
        var sum = 0
        val arr = str1.split('*')
        sum = arr[0].toInt() * arr[1].toInt()

        return sum
    }

    fun Division(str1: String): Int
    {
        var sum = 0
        val arr = str1.split('/')
        sum = arr[0].toInt() / arr[1].toInt()

        return sum
    }

}