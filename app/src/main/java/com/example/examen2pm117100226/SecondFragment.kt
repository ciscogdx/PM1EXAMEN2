package com.example.examen2pm117100226

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = getView()?.findViewById<RecyclerView>(R.id.recyclerview)

        agregarCarros()
        initRecycler(rv)
    }
    fun initRecycler(rv: RecyclerView?){
        if (rv != null) {
            rv.layoutManager = LinearLayoutManager(context)

        }
        val adapter = CarAdapter(Carros.carros)
        if (rv != null) {
            rv.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
    fun agregarCarros(){
        if(!Carros.carros.contains(cars("Ford","Mustang",1999,6,true))){
            Carros.carros.contains(cars("Ford","Mustang",1999,6,true))
            Carros.carros.contains(cars("Ford","Mustang",1999,6,true))
            Carros.carros.contains(cars("Ford","Mustang",1999,6,true))
            Carros.carros.contains(cars("Ford","Mustang",1999,6,true))
        }

    }
}