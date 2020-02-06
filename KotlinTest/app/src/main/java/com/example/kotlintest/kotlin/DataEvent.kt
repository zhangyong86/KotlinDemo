@file:JvmName("RxSchedulers")//注解修改，供顶层函数可被Java调用
package com.example.kotlintest.kotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//顶层函数
fun getSystemModel(): String{
    return android.os.Build.MODEL
}

fun double(x: Int): Int {
    return 2 * x
}

class DataEvent constructor(name: String) {

    var name: String//变量-可读写

    val identityNum = 123456;//常量


    init {
        this.name = name;
    }


    fun getDoubleAge(age: Int): Int{
        return double(age)//顶层函数属于包内，可直接调用
    }

    /**
     * static method
     */
    companion object {
        fun getDouble(num: Int): Int {
            return num * 2;
        }

        const val sex = "boy";//静态常量
    }

    fun main(){
        GlobalScope.launch { // 在后台启动一个新的协程并继续
            delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            println("World!") // 在延迟后打印输出
        }
        println("Hello,") // 协程已在等待时主线程还在继续
        Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
    }

}