package com.pro.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.pro.Model.User
import com.pro.R
import com.pro.ViewModel.RegistrarViewModel
import com.pro.dao.DBHelper

class RegistrarActivity : AppCompatActivity() {

    lateinit var ruser:EditText
    lateinit var rpass:EditText
    lateinit var save:Button
    lateinit var dbHelper: DBHelper
    lateinit var registrarVM: RegistrarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrar_layout)
        inicializar()


        save.setOnClickListener() {
            val user: User = User(ruser.text.toString(), rpass.text.toString())
            if(registrarVM.validar(user)){
                if(dbHelper.saveUsuario(user)){
                    val intent: Intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "No se pudo guardar el usuario en DB", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Debe ingresar nombre y contraseña", Toast.LENGTH_LONG).show()
            }


        }

    }

    fun inicializar(){
        ruser=findViewById(R.id.r_usuario)
        rpass=findViewById(R.id.r_contraseña)
        save=findViewById(R.id.r_registrar)
        dbHelper = DBHelper(this)
        registrarVM = ViewModelProvider(this).get(RegistrarViewModel::class.java)
    }
}