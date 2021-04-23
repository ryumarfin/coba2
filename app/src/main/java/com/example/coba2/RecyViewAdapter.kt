package com.example.coba2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_recy_view.view.*

//class RecyViewAdapter(private val mobil: List<Mobil>) :RecyclerView.Adapter<RecyViewAdapter.ViewHolder>(){
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var nama = itemView.findViewById<TextView>(R.id.namaMobil)
//        var jenis = itemView.findViewById<TextView>(R.id.jenisMobil)
//        var harga = itemView.findViewById<TextView>(R.id.hargaMobil)
//        var kursi = itemView.findViewById<TextView>(R.id.kursiMobil)
//        var bagasi = itemView.findViewById<TextView>(R.id.bagasiMobil)
//        var deskripsi = itemView.findViewById<TextView>(R.id.deskripsi)
//
//        init {
//            itemView.setOnClickListener {v: View ->
//                val position: Int = adapterPosition
//                Toast.makeText(itemView.context, "You clicked on item # ${position + 1}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyViewAdapter.ViewHolder {
//        val v  = LayoutInflater.from(parent.context).inflate(R.layout.layout_recy_view, parent, false)
//        return ViewHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: RecyViewAdapter.ViewHolder, position: Int) {
//        holder.nama.text = mobil[position].Nama
//        holder.jenis.text = mobil[position].Jenis
//        holder.harga.text = mobil[position].Harga.toString()
//        holder.kursi.text = mobil[position].Seat.toString()
//        holder.kursi.text = mobil[position].Bag.toString()
//        holder.deskripsi.text = mobil[position].Deskripsi
//    }
//
//    override fun getItemCount(): Int = mobil.size
//}



//b.7

class RecyViewAdapter(var context: Context, private val mobil :List<Mobil>) : RecyclerView.Adapter<myHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        return myHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recy_view, parent, false))
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        //mengambil data yg dipilih
        holder.bindContact(mobil[position])
        //tambah listenr utk item yg diclik
        holder.itemView.setOnClickListener {
            var intentDetail = Intent(context,SecondActivity::class.java)
            //ambil data dari data class
            var m = Mobil(
                mobil[position].Pic,
                mobil[position].Nama,
                mobil[position].Jenis,
                mobil[position].Harga,
                mobil[position].Seat,
                mobil[position].Bag,
                mobil[position].Deskripsi
            )
            //kirim data ke second activity dgn parcelable
            intentDetail.putExtra(KIRIM_DATA, m)
            context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = mobil.size
}

class myHolder(view: View) : RecyclerView.ViewHolder(view){
    //tampung data
    private val img = view.gambar
    private val nama = view.namaMobil
    private val jenis = view.jenisMobil
    private val harga = view.hargaMobil
    private val kursi = view.kursiMobil
    private val bagasi = view.bagasiMobil
    private val deskripsi = view.deskripsi

    fun bindContact(tmp: Mobil) {
        img.setImageResource(tmp.Pic)
        nama.text = tmp.Nama
        jenis.text = tmp.Jenis
        harga.text = tmp.Harga.toString()
        kursi.text = tmp.Seat.toString()
        bagasi.text = tmp.Bag.toString()
        deskripsi.text = tmp.Deskripsi
    }
}