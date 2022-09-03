package com.example.jetpackcomp.data


import com.example.jetpackcomp.R

data class MenuContentModel(val title : String, val icon : Int)

fun getPropertyDetails() : List<MenuContentModel>{
    val propertyList = ArrayList<MenuContentModel>()
    propertyList.add(MenuContentModel("Property One", (R.drawable.a)))
    propertyList.add(MenuContentModel("Property two", (R.drawable.b)))
    propertyList.add(MenuContentModel("Property three", (R.drawable.c)))
    propertyList.add(MenuContentModel("Property four", (R.drawable.d)))
    propertyList.add(MenuContentModel("Property five", (R.drawable.e)))
    propertyList.add(MenuContentModel("Property siz", (R.drawable.f)))
    propertyList.add(MenuContentModel("Property siz", (R.drawable.g)))
    return propertyList
}