package com.xzk.learn.spider

class SpiderRole {


    /**
     * 爬虫解析规则
     *    roleMap key : 网址
     *            value : HashMap<String,String> 为解析各种类型数据的解析规则（标题、章节、内容）
     */
    private var roleMap: HashMap<String, HashMap<String,String>> = HashMap()



    public fun getRole(roleName: String): HashMap<String, String>? {
        return roleMap[roleName]
    }



    public fun addRole(roleName: String, role: HashMap<String, String>) {
        roleMap[roleName] = role
    }



}