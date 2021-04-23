package com.example.coba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //a.1 buat layout activity_main
        //a.2 buat layout reccleview -> layout -> new -> XML -> LayoutXML
        //a.3 buat Secod activity
        //b.1 buat class Mobil.kt

        //b.4 buat object Mobil
        var m = mutableListOf<Mobil>()
        //1.8 sediakan datanya terlebih dahulu
        m.add(Mobil("Tesla","nobil bagus", 300,6,1,"asdfadff asdfdasf 23 sf 34 fdfa"))
        m.add(Mobil("abc","nobil rusak", 50,4,2,"${R.string.deskripsi}"))

        myRecyView.apply{
            adapter = RecyViewAdapter(this@MainActivity, m)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

//        myRecyView.layoutManager = LinearLayoutManager(this)
//        myRecyView.adapter = RecyViewAdapter(m)
    }
}