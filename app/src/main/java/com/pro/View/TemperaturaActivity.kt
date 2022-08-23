package com.pro.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.pro.R

class TemperaturaActivity : AppCompatActivity() {

    lateinit var temp:EditText
    lateinit var opciones:Spinner
    lateinit var convertir:Button
    lateinit var resultado:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperatura_layout)

        inicializar()
        inicializarSpinner()
        convertir.setOnClickListener(){
            if (temp!=null){
                if (opciones.selectedItem == "°C a °K (Kelvin)") {
                    Toast.makeText(this, temp.text, Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, temp.text, Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Ingrese temperatura a convertir", Toast.LENGTH_LONG).show()
            }
        }

    }

    fun inicializar() {
        temp=findViewById(R.id.e_temp)
        opciones=findViewById(R.id.s_opciones)
        convertir=findViewById(R.id.b_convertidor)
        resultado=findViewById(R.id.t_resultado)
    }

    fun inicializarSpinner(){
        val convertidor= arrayOf("°C a °K (Kelvin)","°K a °C (Celsius)")
        opciones.adapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,convertidor)
    }
}

