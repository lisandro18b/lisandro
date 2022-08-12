package com.pro.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.pro.R

class RegistrarActivity : AppCompatActivity() {

    lateinit var ruser:EditText
    lateinit var rpass:EditText
    lateinit var save:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_layout)
        inicializar()
        save.setOnClickListener() {
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    fun inicializar(){
        ruser=findViewById(R.id.r_usuario)
        rpass=findViewById(R.id.r_contraseña)
        save=findViewById(R.id.r_registrar)
    }
}