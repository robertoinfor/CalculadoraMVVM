package com.example.descuentosapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.descuentosapp.model.CalcularState
import kotlin.math.tan

class CalcularViewModel3 :ViewModel() {
    var state by mutableStateOf(CalcularState())
        private set

    fun calcular(){
        val precio = state.precio
        val descuento = state.descuento
        if (precio != "" && descuento != ""){
            state = state.copy(
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()),
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            )
        } else{
            state = state.copy(showAlert = true)
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
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
            "precioDescuento" -> state = state.copy(precioDescuento = value.toDouble())
            "totalDescuento" -> state = state.copy(totalDescuento = value.toDouble())
            "showAlert" -> state = state.copy(showAlert =
                if (value == "true") {
                    true
                } else {
                    false
                })

        }
    }

    fun limpiar(){
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            totalDescuento = 0.0
        )
    }

    fun cancelarAlerta(){
        state = state.copy(showAlert = false)
    }
}