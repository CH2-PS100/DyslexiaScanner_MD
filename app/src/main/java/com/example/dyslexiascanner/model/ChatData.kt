package com.example.dyslexiascanner.model

class ChatData {
    var name: String? = null
    var info: String? = null
    var img: String? = null
    var years: String? = null
    var price: String? = null

    constructor(){}
    constructor(
        name:String?,
        info:String?,
        img:String?,
        years:String?,
        price: String?
    ){
        this.name = name
        this.info = info
        this.img = img
        this.years = years
        this.price = price
    }
}