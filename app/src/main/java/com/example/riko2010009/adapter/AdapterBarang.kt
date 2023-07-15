package com.example.riko2010009.adapter


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.riko2010009.R
import com.example.riko2010009.model.BarangModel
import com.squareup.picasso.Picasso
import kotlin.collections.ArrayList

class AdapterBarang(var activity: Activity, var data:ArrayList<BarangModel>): RecyclerView.Adapter<AdapterBarang.Holder>(){
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNamaBarang: TextView = view.findViewById(R.id.tvnamabarang)
        val tvHarga: TextView = view.findViewById(R.id.tvharga)
        val tvDeskripsi: TextView = view.findViewById(R.id.tvdeskripsi)
        val tvKategori: TextView = view.findViewById(R.id.tvkategori)
        val imgProduk: ImageView = view.findViewById(R.id.img_produk)
    }

lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false)
        return Holder(view)
    }
@SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]

        holder.tvNamaBarang.text = a.nama
        holder.tvHarga.text = a.harga
        holder.tvDeskripsi.text = a.deskripsi
        holder.tvKategori.text = a.category


        val image = "http://21.342.53.43/startup/public/storage/image/${a.image}"
        Picasso.get()
            .load(image)
            .into(holder.imgProduk)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
