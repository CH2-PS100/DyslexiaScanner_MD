package com.example.dyslexiascanner.model

class ArticleData {
    var name: String? = null
    var info: String? = null
    var img: String? = null
    var dateTime: String? = null

    constructor(){}

    constructor(
        name:String?,
        info:String?,
        img:String?,
        dateTime: String?
    ){
        this.name = name
        this.info = info
        this.img = img
        this.dateTime = dateTime
    }

}