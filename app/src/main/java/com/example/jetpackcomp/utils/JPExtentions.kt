package com.example.jetpackcomp.utils



var EMPTY_STRING = ""

fun String.addArgument(value : Any): String{
    return this.plus("/").plus(value)
}