package com.zs.kotlin.mykotlin.activity

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.zs.kotlin.mykotlin.R
import com.zs.kotlin.mykotlin.bean.Book
import org.jetbrains.anko.dip
import org.jetbrains.anko.sp
import org.jetbrains.anko.toast

/**
 *
Created by zs
Date：2017年 07月 05日
Time：15:27
—————————————————————————————————————
About:语法
—————————————————————————————————————
 */
class GrammarActivity : android.support.v7.app.AppCompatActivity() , View.OnClickListener {

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


        // 点击事件的四种写法

//        mTv?.setOnClickListener(this)

//        mTv?.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                Toast.makeText(v?.context,"  ***  mTv1 ***",Toast.LENGTH_SHORT).show()
//            }
//
//        })

        mTv?.setOnClickListener { v -> Toast.makeText(v?.context,"  ***  mTv1 ***",Toast.LENGTH_SHORT).show() }

        mTv2?.setOnClickListener(View.OnClickListener {
            Toast.makeText(GrammarActivity@this,"***  mTv2 ****",Toast.LENGTH_SHORT).show()
        })

        mIv1?.setOnClickListener{
            Toast.makeText(GrammarActivity@this," **** image **** ",Toast.LENGTH_SHORT).show()
        }

        // 单位转换
        var dpAsPx = dip(10)
        var spAsPx = sp(10f)
        Log.d("My_Log_turn","dpAsPx ==  " + dpAsPx + "\nspAsPx == " + spAsPx)

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

        j.swap(0,1)

        for (i in j.indices){
            j.get(i)
        }

        var positives = j.filter { x -> x > 0 }

        android.util.Log.d("My_Log", "  "+ positives ?.size ?: "empty" )

        android.util.Log.d("My_Log","positives = ${positives.toString()}")

        positives = j.filter { it > 1 }

        android.util.Log.d("My_Log","positives = ${positives.toString()}")

        toast("hh")

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

        var map = mapOf(1 to 1,2 to 2, 3 to 3)
        for ((key,value) in map){
            println("value ${value}")
        }

        for ((_,value) in map){
            println("value ${value}")
        }

        // Lambda表达式
        var sun:(Int,Int) -> Int = {x,y -> x + y}
        // 匿名函数
        fun (x: Int,y: Int): Int = x + y

        fun compare(a: String, b: String): Boolean = a.length < b.length
        fun compare(a: Int,b: Int) : Boolean = a > b
    }

    override fun onClick(v: View?) {
        when(v?.id){

            R.id.tv_main -> Toast.makeText(GrammarActivity@this,"111111",Toast.LENGTH_SHORT).show()

        }

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

    /**
     * 判断多个条件整合
     */
    fun check(value: Any?): String = when (value) {
        is Int, is Float, is Double -> {
            if (value == 0) "value为0"
            else "value = $value"
        }
        else -> {
            "value为空"
        }
    }

    /**
     * 扩展函数
     */
    fun <T> MutableList<T>.swap(index1: Int,index2: Int){
        val temp = this[index1]
        this[index1] = this[index2]
        this[index2] = temp
    }


    /**
     * 可变参数
     *
     * 类似：getParams(String... params)
     */
    fun <T> getParams(vararg ts: T) : List<T>{
        var result = ArrayList<T>()
        for (t in ts){
          result.add(t)
        }
        return result
    }

    fun getMyParams(){
        var a = arrayOf(1,2,3)

        var list = getParams(0,3,*a,4) // 表示(0, 3, 1, 2, 3, 4)

    }
}
