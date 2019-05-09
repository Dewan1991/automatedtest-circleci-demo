package io.centrilliontech.suprinya.automatedtestcirclecidemo

import com.google.gson.Gson

class Dummy{
    companion object {
        const val NAME = ""


    }

    //for(shoe in shoesShelfContainer.data){ }
    //for (i in 0 until shoesShelfContainer.data.size)
    //for (i in 0..shoesShelfContainer.data.size)
    //for (i in 0..shoesShelfContainer.data.size)

    //zeroIfNull("", getShoes())

    private val gson: Gson  by lazy {
        Gson()
    }
}
fun zeroIfNull(str: String?, body: Unit) {
    body
}
