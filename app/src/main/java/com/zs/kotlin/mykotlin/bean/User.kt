package com.zs.kotlin.mykotlin.bean

/**
 *
Created by zs
Date：2017年 07月 04日
Time：17:00
—————————————————————————————————————
About:
—————————————————————————————————————
 */
class User{
    var name: String? = null
    var age: Int? = null

    constructor(name: String , age: Int = 18){
        this.name = name
        this.age =age
    }

    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }

}
