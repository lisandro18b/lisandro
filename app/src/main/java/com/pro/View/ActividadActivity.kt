package com.pro.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pro.Model.User
import com.pro.R
import com.pro.dao.DBHelper

class ActividadActivity : AppCompatActivity() {

    lateinit var saludo:TextView
    lateinit var indicador:TextView
    lateinit var palindromo:Button
    lateinit var pal:TextView
    lateinit var temperatura:Button
    lateinit var temp:TextView
    lateinit var fibonacci:Button
    lateinit var fibo:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_layuot)

        inicializar()
        val usuario: User= intent.getSerializableExtra("nombre") as User
        saludo.text="Bienvenido ${usuario.name}"

        palindromo.setOnClickListener(){
            val intent: Intent = Intent(this,PalindromoActivity::class.java)
            startActivity(intent)
        }
        temperatura.setOnClickListener(){
            val intent: Intent = Intent(this,TemperaturaActivity::class.java)
            startActivity(intent)
        }
        fibonacci.setOnClickListener(){
            val intent: Intent = Intent(this,FibonacciActivity::class.java)
            startActivity(intent)
        }
    }

    fun inicializar(){
        saludo=findViewById(R.id.a_saludo)
        indicador=findViewById(R.id.a_indicador)
        palindromo=findViewById(R.id.b_palindromo)
        pal=findViewById(R.id.t_pal)
        temperatura=findViewById(R.id.b_temperatura)
        temp=findViewById(R.id.t_temp)
        fibonacci=findViewById(R.id.b_fibonacci)
        fibo=findViewById(R.id.t_fibo)
    }
}
