package com.example.jetpackcomp.utils



fun String.addArgument(value : Any): String{
    return this.plus("/").plus(value)
}