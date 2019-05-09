package io.centrilliontech.suprinya.automatedtestcirclecidemo

data class ShoesShelf(

        val id: Int = -1,
        val name: String = "",
        val amount: Int = 0,
        val available: Boolean = false,
        val image: String = ""
)

data class ShoesShelfContainer(
        val data: ArrayList<ShoesShelf> = arrayListOf()
)