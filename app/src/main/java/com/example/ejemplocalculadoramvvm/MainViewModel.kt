package com.example.ejemplocalculadoramvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

// ---------- Suma ---------- //

    //Opcion 1
    val add : MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }

    val substrac : MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }

    val multiply : MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }

    val divide : MutableLiveData<Double> by lazy{
        MutableLiveData<Double>()
    }

    //Opcion 2
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    fun addOperation(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()){
            _errorMsg.value = "Debe digitar dos números"
        }else {
            add.value = number1.toDouble() + number2.toDouble()
        }
    }

    fun substractOperation(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()){
            _errorMsg.value = "Debe digitar dos números"
        }else {
            add.value = number1.toDouble() - number2.toDouble()
        }
    }

    fun multiplyOperation(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()){
            _errorMsg.value = "Debe digitar dos números"
        }else {
            add.value = number1.toDouble() * number2.toDouble()
        }
    }

    fun divisionOperation(number1: String, number2: String) {
        if (number1.isEmpty() || number2.isEmpty()){
            _errorMsg.value = "Debe digitar dos números"
        }else {
            add.value = number1.toDouble() / number2.toDouble()
        }
    }

}