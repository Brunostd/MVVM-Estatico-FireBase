package com.deny.studyarchietecturemvvm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.deny.studyarchietecturemvvm.R

class MainActivity : AppCompatActivity() {

    private lateinit var buttonConteudo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonConteudo = findViewById(R.id.buttonConteudo)

        buttonConteudo.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Conteudo::class.java)
            startActivity(intent)
        })
    }
}