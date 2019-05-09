package io.centrilliontech.suprinya.automatedtestcirclecidemo

import io.reactivex.Flowable
import retrofit2.http.GET


interface ShoesService {

    @GET("test.json")
    fun getShoes(): Flowable<ShoesShelfContainer>

}