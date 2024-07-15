package com.xzk.learn.entry

/**
 * Item
 * @author frieze
 *   @param name 技术点名称
 *   @param url 参考链接
 *   @param des 技术点描述
 *   @param summary 总结
 *   @param picList 图片链接
 */
data class Item(val name: String, val url: String, val des: String, val summary: String,val picList: ArrayList<String>)