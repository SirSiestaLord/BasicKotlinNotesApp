package com.example.basicnotesapp

import android.content.Context
import android.content.Intent
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

class SpecialAdapter(applicationContext: Context, list: ArrayList<String>) : BaseAdapter() {
    var inflater:LayoutInflater= applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var liste=list
    var cont=applicationContext
    override fun getCount(): Int {
    return liste.size
    }

    override fun getItem(position: Int): Any {
        return liste.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View
        view=inflater.inflate(R.layout.listlay,null)
        val text=view.findViewById<TextView>(R.id.text5)
        val but =view.findViewById<Button>(R.id.button2)
        but.setOnClickListener(View.OnClickListener {
            liste.removeAt(position)
            val intent = Intent(cont?.applicationContext,MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("liste",liste)
            cont.startActivity(intent)

        })
        text.text=liste.get(position)
        text.setOnClickListener(View.OnClickListener {
            val tost=Toast.makeText(cont,liste.get(position),Toast.LENGTH_LONG)
            tost.show()
        })
        return view
    }

}