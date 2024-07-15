package com.xzk.learn.spider.impl

import com.xzk.learn.spider.BookInfo
import com.xzk.learn.spider.SpiderMan
import com.xzk.learn.spider.SpiderRole

class SimpleSpiderMan:SpiderMan {
    override fun setSpiderRole(spiderRole: SpiderRole) {

    }

    override fun getSpiderRole(): SpiderRole {
        return SpiderRole()
    }

    override fun getBookInfo(): BookInfo {
        return BookInfo()
    }
}