package com.example.descuentosapp.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalcularViewModel2 : ViewModel(){
    private val _precio = mutableStateOf(Double)
    var precio: State<Double> = _precio

    private val _descuento = mutableStateOf(Double)
    var descuento: State<Double> = _descuento
}