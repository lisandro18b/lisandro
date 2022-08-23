package com.pro.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.pro.R
import com.pro.ViewModel.TemperaturaViewModel

class TemperaturaActivity : AppCompatActivity() {

    lateinit var temp:EditText
    lateinit var opciones:Spinner
    lateinit var convertir:Button
    lateinit var resultado:TextView
    lateinit var viewModel: TemperaturaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperatura_layout)

        inicializar()
        inicializarSpinner()
        convertir.setOnClickListener(){
            if (viewModel.validarTemp(temp.text.toString())){
                if (viewModel.validarSpinner(opciones.selectedItem)) {
                    Toast.makeText(this, temp.text, Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, temp.text, Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Ingrese temperatura a convertir", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun inicializar() {
        temp=findViewById(R.id.e_temp)
        opciones=findViewById(R.id.s_opciones)
        convertir=findViewById(R.id.b_convertidor)
        resultado=findViewById(R.id.t_resultado)
        viewModel = ViewModelProvider(this).get(TemperaturaViewModel::class.java)
    }

    private fun inicializarSpinner(){
        val convertidor= arrayOf("°C a °K (Kelvin)","°K a °C (Celsius)")
        opciones.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,convertidor)
    }
}

