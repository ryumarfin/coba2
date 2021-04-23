package com.example.coba2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mobil(var Pic : Int,
                var Nama : String ="nama mobil",
                var Jenis : String = "jenis mobil",
                var Harga : Int = 0,
                var Seat : Int = 1,
                var Bag : Int = 1,
                var Deskripsi : String = "deskripsiiii"): Parcelable

//b.2 ke gradle