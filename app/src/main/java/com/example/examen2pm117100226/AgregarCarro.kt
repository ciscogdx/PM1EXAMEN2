package com.example.examen2pm117100226

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class AgregarCarro: AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agg_carro)
        val btnDialogo : Button = findViewById(R.id.btnAgregar)
        btnDialogo.setOnClickListener(){
            val alertDialog: AlertDialog? = this?.let {
                val builder = AlertDialog.Builder(it)

                builder.setTitle("Los datos están correctos?")

                builder.apply {
                    setPositiveButton("Agregar",
                        DialogInterface.OnClickListener { dialog, id ->
                            var cadena = AgregarCarro()
                            mostrarAlert(cadena)
                            Toast.makeText(context, "Se agregó correctamente", Toast.LENGTH_LONG).show()
                        })
                    setNegativeButton("Cancelar",
                        DialogInterface.OnClickListener { dialog, id ->
                            Snackbar.make(findViewById<View>(R.id.myLayout), "No se agregó", Snackbar.LENGTH_SHORT).show()
                        })
                }
                builder.create()
            }
            alertDialog?.show()
        }
    }

    fun AgregarCarro(): String{
        val spnMarca = findViewById<Spinner>(R.id.spinnerMarcas)
        val txtNombre = findViewById<EditText>(R.id.etNombreCarro).text
        val txtAnio = findViewById<EditText>(R.id.etYear).text
        val txtCilindros = findViewById<EditText>(R.id.etCilindros).text
        val chkMex: CheckBox = findViewById(R.id.ckbMexicano)
        spnMarca.onItemSelectedListener = this
        val marca = spnMarca.selectedItem.toString()
        var blnTipo = if(chkMex.isChecked) true else false //nacionalidad

        //val nombre:String,val anio:Int,val cilindros:Int,val Tipo:String
        Carros.carros.add(cars(marca,txtNombre.toString(),txtAnio.toString().toInt(),txtCilindros.toString().toInt(),blnTipo))
        var txtNacionalidad = if(blnTipo) "Mexicano" else "Americano"
        return "Carro insertado:  ${marca},${txtNombre} ,${txtCilindros} cilindros, $txtNacionalidad"
    }

    fun mostrarAlert(cadena: String){
        val alertDialog: AlertDialog? = this?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Compartir el carro insertado?")
            builder.apply { setPositiveButton("Sí",
                    DialogInterface.OnClickListener { dialog, id ->
                        val sendIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "${cadena}")
                            type = "text/plain"
                        }
                        if (sendIntent.resolveActivity(packageManager) != null) {
                            startActivity(sendIntent)
                        }
                    })
                setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            }
            builder.create()
        }
        alertDialog?.show()
    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.getItemAtPosition(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}