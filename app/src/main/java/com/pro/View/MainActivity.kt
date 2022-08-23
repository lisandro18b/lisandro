package com.pro.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.pro.Model.User
import com.pro.R
import com.pro.dao.DBHelper

class MainActivity : AppCompatActivity() {

    lateinit var nombre:EditText
    lateinit var contraseña:EditText
    lateinit var ingresar:Button
    lateinit var registrar:Button
    lateinit var user:User
    lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        user=User(nombre.text.toString(),contraseña.text.toString())

        ingresar.setOnClickListener(){
            user=User(nombre.text.toString(),contraseña.text.toString())
            if(dbHelper.getUsuario(user)) {
                val intent:Intent= Intent(this,ActividadActivity::class.java)
                intent.putExtra("nombre",user)
                startActivity(intent)
            } else {
                Toast.makeText(this,"USUARIO NO REGISTRADO",Toast.LENGTH_LONG).show()
            }
        }

        registrar.setOnClickListener(){
            val intent:Intent= Intent(this,RegistrarActivity::class.java)
            startActivity(intent)
        }
    }

    fun inicializar(){
        dbHelper = DBHelper(this)
        nombre=findViewById(R.id.me_usuario)
        contraseña=findViewById(R.id.me_contraseña)
        ingresar=findViewById(R.id.mb_ingresar)
        registrar=findViewById(R.id.mb_registrar)
    }
}