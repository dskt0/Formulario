package com.example.formulario

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val sharedP = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rut = findViewById<EditText>(R.id.textRut)
        val nombre = findViewById<EditText>(R.id.textNombre)
        val correo = findViewById<EditText>(R.id.textCorreo)
        val botonBuscar = findViewById<Button>(R.id.btnBuscar)
        val botonGuardar = findViewById<Button>(R.id.btnGuardar)

        val sp =getSharedPreferences(sharedP, Context.MODE_PRIVATE)


        botonGuardar.setOnClickListener(){
            val editor = sp.edit()
            editor.putString(rut.text.toString(), nombre.text.toString())
            editor.putString(rut.text.toString(), correo.text.toString())
            editor.apply()
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
            rut.setText("")
            nombre.setText("")
            correo.setText("")

        }

        botonBuscar.setOnClickListener(){
            val getNombre = sp.getString(rut.text.toString(), "")

            if(getNombre!!.isNotEmpty()){
                nombre.setText(getNombre)
            }else{
                Toast.makeText(this, "Usuario no Encontrado", Toast.LENGTH_LONG).show()
            }

        }
    }
}