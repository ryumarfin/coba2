package com.example.coba2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var m = intent.getParcelableExtra<Mobil>(KIRIM_DATA)
        gambar2.setImageResource(m!!.Pic)
        namaMobil2.text = m?.Nama
        jenisMobil2.text = m?.Jenis
        hargaMobil2.text = m?.Harga.toString()
        kursiMobil2.text = m?.Seat.toString()
        bagasiMobil2.text = m?.Bag.toString()
        deskripsi2.text = m?.Deskripsi


        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        tanggal.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener {
                        view, year, monthOfYear, dayOfMonth ->
                            // Display Selected date in TextView
                            tanggal.setText("$dayOfMonth / ${monthOfYear+1} / $year")
                }, year, month, day)
            datePickerDialog.show()
        }
    }
}