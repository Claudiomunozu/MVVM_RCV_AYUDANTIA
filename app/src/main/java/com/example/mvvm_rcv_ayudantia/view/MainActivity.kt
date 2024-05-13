package com.example.mvvm_rcv_ayudantia.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_rcv_ayudantia.databinding.ActivityMainBinding
import com.example.mvvm_rcv_ayudantia.model.Lenguage
import com.example.mvvm_rcv_ayudantia.view.adapters.LenguageAdapter
import com.example.mvvm_rcv_ayudantia.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        var adapterLenguage = LenguageAdapter()
        mainBinding.rcv.adapter = adapterLenguage

        viewModel.lenguagesLV.observe(this, Observer {

            mainBinding.rcv.layoutManager = LinearLayoutManager(this)
            adapterLenguage.lenguages = it

            adapterLenguage.onItemClickListener = {
                //Toast.makeText(this,it.nombre, Toast.LENGTH_SHORT).show()
                enviarCorreoElectronico(it)
            }

        })

    }

    private fun enviarCorreoElectronico(lenguage: Lenguage) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("claudio.munoz.u@gmail.com"))

        intent.putExtra(Intent.EXTRA_SUBJECT, "ENVIO LENGUAGE CLICKEADO")
        intent.putExtra(Intent.EXTRA_TEXT, "hola envio lenguaje de programacion elegido ${lenguage.nombre}")

        if (intent.resolveActivity(packageManager) != null){

            startActivity(Intent.createChooser(intent, "Enviar correo electronico"))
        }else{
            Toast.makeText(this, "Aplicacion de correo no encontrada", Toast.LENGTH_SHORT).show()
        }

    }

}