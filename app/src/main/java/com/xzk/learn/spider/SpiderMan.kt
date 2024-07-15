package com.xzk.learn.spider

/**
 * created by xiezekai on 2024/3/14
 */
public interface SpiderMan {
    //设置解析规则
    public fun setSpiderRole(spiderRole: SpiderRole)

    //获取解析规则
    public fun getSpiderRole():SpiderRole

    //获取封装好的书本信息
    public fun getBookInfo(): BookInfo
}