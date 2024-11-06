package com.example.descuentosapp.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.descuentosapp.components.Alert
import com.example.descuentosapp.components.MainButton
import com.example.descuentosapp.components.MainTextField
import com.example.descuentosapp.components.SpaceH
import com.example.descuentosapp.components.TwoCards
import com.example.descuentosapp.viewModels.CalcularViewModel1
import com.example.descuentosapp.viewModels.CalcularViewModel2


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel2: CalcularViewModel2) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "App descuentos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
        ContentHomeView(it, viewModel2)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues, viewModel2: CalcularViewModel2) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TwoCards(
            title1 = "Total",
            number1 = viewModel2.totalDescuento,
            title2 = "Descuento",
            number2 = viewModel2.precioDescuento
        )

        MainTextField(value = viewModel2.precio, onValueChange = { viewModel2.onValue(it, "precio") }, label = "Precio")
        SpaceH()
        MainTextField(value = viewModel2.descuento, onValueChange = { viewModel2.onValue(it, "descuento") }, label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            val result = viewModel2.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Red) {
            viewModel2.onValue("", "precio")
            viewModel2.onValue("", "descuento")
            viewModel2.onValue("", "precioDescuento")
            viewModel2.onValue("", "totalDescuento")
        }

        if (viewModel2.showAlert){
            Alert(title = "Alerta",
                message = "Escribe el precio y descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel2.onValue("false", "showAlert") }) { }
        }

    }
}




