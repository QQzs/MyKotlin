package com.zs.kotlin.mykotlin.bean

/**
 * Created by z on 2017/6/2.
 */

data class Live39Info(var rolelist: List<RoleList> = ArrayList<Live39Info.RoleList>()) : BaseInfo() {

    data class RoleList(var rolecode: String?,
                        var rolename: String?)
//    {
//        var rolecode: String? = null
//        var rolename: String? = null
//
//        constructor() {}
//
//        constructor(rolecode: String, rolename: String) {
//            this.rolecode = rolecode
//            this.rolename = rolename
//        }
//    }
}
