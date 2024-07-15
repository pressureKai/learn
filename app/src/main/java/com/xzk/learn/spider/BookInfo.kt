package com.xzk.learn.spider

class BookInfo {
    private var bookName: String? = null
    private var bookAuthor: String? = null
    private var bookDesc: String? = null
    private var bookCover: String? = null
    private var bookChapters: List<ChapterInfo>? = null

    constructor(){

    }
    constructor(
        bookName: String?,
        bookAuthor: String?,
        bookDesc: String?,
        bookCover: String?,
        bookChapters: List<ChapterInfo>?
    ) {
        this.bookName = bookName
        this.bookAuthor = bookAuthor
        this.bookDesc = bookDesc
        this.bookCover = bookCover
        this.bookChapters = bookChapters
    }
}