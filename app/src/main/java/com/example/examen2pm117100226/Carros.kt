package com.example.examen2pm117100226

object Carros {
    val carros: ArrayList<cars> = arrayListOf()
}
data class cars(
    val marca:String,
    val nombre:String,
    val anio:Int,
    val cilindros:Int,
    val Tipo: Boolean
) {

    val tipo = if(Tipo) "Mexicano" else "Americano"
    val Imagen =
        when(marca){
            "Dodge" -> R.drawable.dodge_logo
            "Ford" -> R.drawable.fordlogo
            "Nissan" -> R.drawable.nissanlogo
            "Tesla" -> R.drawable.teslalogo
            "Chevrolet" -> R.drawable.chevroletlogo
            else ->
                R.drawable.logona
        }

}
