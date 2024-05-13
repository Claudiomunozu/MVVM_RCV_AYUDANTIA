package com.example.mvvm_rcv_ayudantia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_rcv_ayudantia.model.Lenguage


class MainViewModel : ViewModel() {

    private var _lenguageList = MutableLiveData<MutableList<Lenguage>>()

    val lenguagesLV: LiveData<MutableList<Lenguage>>//observador
        get() = _lenguageList

    init {
        fetchLenguages()
    }


    fun fetchLenguages(){
        val lngList = mutableListOf<Lenguage>(
            Lenguage(1, "Kotlin"),
            Lenguage(2, "JAVA"),
            Lenguage(3, "PHYTON"),
            Lenguage(4, "C++"),
            Lenguage(5, "TYPESCRIPT"),
            Lenguage(6, "JAVASCRIPT"),
            Lenguage(7, "PASCAL"),
            Lenguage(8, "CLIPPER")
        )

        _lenguageList.value = lngList
    }

}
