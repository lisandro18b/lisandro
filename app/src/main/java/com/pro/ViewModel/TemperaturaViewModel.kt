package com.pro.ViewModel

import androidx.lifecycle.ViewModel

class TemperaturaViewModel: ViewModel() {

    fun validarTemp(temp: String): Boolean {
        return !temp.isNullOrBlank()
    }

    fun validarSpinner(opcion: Any): Boolean {
        return opcion == "°C a °K (Kelvin)"
    }
}