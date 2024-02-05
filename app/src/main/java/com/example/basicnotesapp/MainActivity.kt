package com.example.basicnotesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        var list:ArrayList<String> = ArrayList<String>()
        setContentView(R.layout.newlayout)
        val button=findViewById<Button>(R.id.button)
        val edittext=findViewById<EditText>(R.id.editTextText)
        val listview =findViewById<ListView>(R.id.listviw)
        if(intent.getStringArrayListExtra("liste")!=null){
            list= intent.getStringArrayListExtra("liste")!!
            val a=SpecialAdapter(applicationContext,list)
            listview.adapter=a

        }


        button.setOnClickListener(View.OnClickListener {
            list.add(edittext.text.toString())
            val a=SpecialAdapter(applicationContext,list)
            listview.adapter=a
        })



    }

}

