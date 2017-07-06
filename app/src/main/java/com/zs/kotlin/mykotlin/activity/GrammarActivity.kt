package com.zs.kotlin.mykotlin.activity

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.zs.kotlin.mykotlin.bean.Book

/**
 *
Created by zs
Date：2017年 07月 05日
Time：15:27
—————————————————————————————————————
About:语法
—————————————————————————————————————
 */
class GrammarActivity : android.support.v7.app.AppCompatActivity() {

    private var mTv: android.widget.TextView? = null
    private var mTv2: android.widget.TextView? = null
    private var mIv1: android.widget.ImageView? = null

    private var nInt = 1_000_1000
    private var d: Int? = 1
    private var a: Short? = 1
    private var b: Long? = null;
    // 数组  [1, 2, 3]
    private var c = arrayOf(1,2,3)
    // 空的定长度的数组
    private var e = arrayOfNulls<Int>(5)
    // 创建 Array<String> 内容为 ["0", "1", "4", "9", "16"]
    private var f = Array(5,{i ->(i * i).toString()})
    private var g: Char? = null
    private var h = ArrayList<Book>()
    private var i = HashMap<Int,Book>()

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.zs.kotlin.mykotlin.R.layout.activity_main)
        mTv = findViewById(com.zs.kotlin.mykotlin.R.id.tv_main) as TextView
        mTv2 = findViewById(com.zs.kotlin.mykotlin.R.id.tv_main2) as TextView
        mIv1 = findViewById(com.zs.kotlin.mykotlin.R.id.iv_main1) as ImageView

        mTv?.text = "1234567890"
        mTv2?.text = "22222222"
        mIv1?.setImageResource(com.zs.kotlin.mykotlin.R.mipmap.ic_launcher)

        /**
         * 把Short类型的 a 强转成 Int
         * Kotlin 短类型是不会隐式(自动)转换为长类型的，需要显示(手动)转换才行
         */
        a!!.toInt()
        // Long  + Int => Long，自动转换成Long类型
        var b = d!!.toLong() + 1

        var h = "abc"
        var str = "$h.length is ${h.length}"  //识别为 "abc.length is 3"

        var i = listOf("1","2","3")
        var j = mutableListOf<Int>()
        j!!.add(-1)
        j!!.add(1)
        j.add(2)

        for (i in j.indices){
            j.get(i)
        }

        var positives = j.filter { x -> x > 0 }

        android.util.Log.d("My_Log", "  "+ positives ?.size ?: "empty" )

        android.util.Log.d("My_Log","positives = ${positives.toString()}")

        positives = j.filter { it > 1 }

        android.util.Log.d("My_Log","positives = ${positives.toString()}")

        // 如果 positives 执行
        positives ?.let {

        }


        var k =  mutableListOf<Int>()
        k.add(1)

        var l = mutableMapOf<Int,String>()
        l.put(0,"0")
        l.put(1,"1")
        l.put(3,"4")

        var setEntry = l.entries
        setEntry.forEach {
            Log.d("My_Log","key = ${it.key} , value = ${it.value}")
        }
        for ((k,v) in l){
            Log.d("My_Log","key = $k , value = $v")
        }

        Log.d("My_Log","result = " + getResult1())
        try {
            getResult2(1,2)
        } catch(e: Exception) {

        }
        android.util.Log.d("My_Log","result = " + getResult3(5,6))

    }

    private fun getResult1(): Int{

        var x: Int = 1;
        var y = 2;
        var z: Int
        z = 3
        return x + y + z;
    }

    fun getResult2(a: Int, b: Int){
        android.util.Log.d("My_Log","result = " + (a + b))

    }

    fun getResult3(a: Int , b:Int): String{
        return "" + (a + b)
    }

    /**
     * 判断
     */
    fun judge(x: Int, y: Int){
        if (x in 1..y){
            android.util.Log.d("My_Log"," 1 <=x <= y")
        }

        if(g in '0' .. '9'){
            g!!.toInt()
        }

    }

    /**
     * for 循环
     */
    fun getResult4(data: Array<String>){

        if (data.size == 0) return
        for(d in data){
            android.util.Log.d("My_Log","data = : ${d}")
        }

        for(i in data.indices){
            android.util.Log.d("My_Log","data = " + data[i])
        }

        for (i in 1..10){
            android.util.Log.d("My_Log"," 1 到 10")
        }

        for( i in 1 until 10){
            android.util.Log.d("My_Log"," 1 到 9 不包括 10")
        }
    }

    /**
     * when 表达式  类似 Java switch
     */
    fun case(obj: Any){

        when(obj){
            1           -> android.util.Log.d("My_Log","1")
            "Hello"     -> android.util.Log.d("My_Log","Hello")
            is Long     -> android.util.Log.d("My_Log","Long")
            !is String  -> android.util.Log.d("My_Log","not String ")
            else        -> android.util.Log.d("My_Log","default")
        }

    }

    fun tranform(flag : String) : Int = when(flag){
        "red"   -> 1
        "blue"  -> 2
        else    -> 0
    }
}
