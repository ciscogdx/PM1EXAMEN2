package com.example.examen2pm117100226

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(val lstCarros:List<cars>):
    RecyclerView.Adapter<CarAdapter.LegendsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegendsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LegendsHolder(layoutInflater.inflate(R.layout.item_car,parent, false))
    }

    override fun getItemCount(): Int {
        return lstCarros.size
    }

    override fun onBindViewHolder(holder: LegendsHolder, position: Int) {
        holder.render(lstCarros[position])
    }

    class LegendsHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun render(carros: cars){
            val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
            val txtCilindros = view.findViewById<TextView>(R.id.txtCilindros)
            val txtAnio = view.findViewById<TextView>(R.id.txtYear)
            val txtTipo = view.findViewById<TextView>(R.id.txtTipo)
            val txtMarca = view.findViewById<TextView>(R.id.txtMarca)
            val imgImagen = view.findViewById<ImageView>(R.id.imageView)
            txtNombre.text = carros.nombre
            txtCilindros.text = carros.cilindros.toString()
            txtTipo.text = carros.tipo
            txtMarca.text =carros.marca
            txtAnio.text = carros.anio.toString()
            imgImagen.setImageDrawable(view.resources.getDrawable(carros.Imagen))
        }
    }
}