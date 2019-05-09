package io.centrilliontech.suprinya.automatedtestcirclecidemo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val data = MutableLiveData<ShoesShelfContainer>()

    fun initLoad() {
        Network.shoesService.getShoes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.value = it
                },
                        {
                            TODO("Later!")
                        })

    }

    fun getShoesShelf(): LiveData<ShoesShelfContainer> {
        return data
    }
}