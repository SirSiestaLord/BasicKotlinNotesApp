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
        var button=findViewById<Button>(R.id.button)
        var edittext=findViewById<EditText>(R.id.editTextText)
        var listview =findViewById<ListView>(R.id.listviw)
        if(intent.getStringArrayListExtra("liste")!=null){
            list= intent.getStringArrayListExtra("liste")!!
            var a=SpecialAdapter(applicationContext,list)
            listview.adapter=a

        }


        button.setOnClickListener(View.OnClickListener {
            list.add(edittext.text.toString())
            var a=SpecialAdapter(applicationContext,list)
            listview.adapter=a
        })



    }

}

