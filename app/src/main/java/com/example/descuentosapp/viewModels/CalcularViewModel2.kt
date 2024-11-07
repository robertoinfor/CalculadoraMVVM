package com.example.descuentosapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2 : ViewModel(){
    var precio by mutableStateOf("")
        private set

    var descuento by mutableStateOf("")
        private set

    var precioDescuento by mutableStateOf("")
        private set

    var totalDescuento by mutableStateOf("")
        private set

    var showAlert by mutableStateOf(false)
        private set

    fun calcular(){
        if (precio != "" && descuento != ""){
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()).toString()
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble()).toString()
        } else{
            showAlert = true
        }
    }

    fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * ( 1 - descuento /100 )
        return kotlin.math.round(res * 100) /100.0
    }

    fun calcularPrecio(precio: Double, descuento: Double) : Double{
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) /100.0
    }

    fun onValue(value: String, text: String){
        when (text){
            "precio" -> precio = value
            "descuento" -> descuento = value
            "precioDescuento" -> precioDescuento = value
            "totalDescuento" -> totalDescuento = value
            "showAlert" -> showAlert =
                if (value == "true") {
                    true
                } else {
                    false
                }

        }
    }

    fun limpiar(){
        precio = ""
        descuento = ""
        precioDescuento = ""
        totalDescuento = ""
    }

    fun cancelarAlerta(){
        showAlert = false
    }
}