package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var list = ArrayList<Data>()
    lateinit var adapter : RecyclerViewAdapter
    lateinit var addBut : Button
    lateinit var inputText : EditText
    lateinit var delBut : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addBut = findViewById<Button>(R.id.buttonAdd)
        inputText = findViewById<EditText>(R.id.inputItem)
        delBut = findViewById<Button>(R.id.deleteButton)

        inputText.addTextChangedListener(textWatcher)

        //delBut.setOnClickListener { deldata() }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val checkInput = inputText.text.toString().trim()
            addBut.setEnabled(!checkInput.isEmpty())
            addBut.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {

        if (TextUtils.isEmpty(inputText.text.toString())) {
            addBut.setEnabled(false)
            Toast.makeText(this, "Empty input", Toast.LENGTH_SHORT).show()
        }else {
            addBut.isEnabled()
            //addBut.setBackgroundColor(R.drawable.butcolor);
            setupdata()
            adapter = RecyclerViewAdapter(list)
            val recyclerview = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerview)
            recyclerview.layoutManager = LinearLayoutManager(this)
            recyclerview.adapter = adapter
        }
    }
    private fun setupdata(){
        var string = inputText.text.toString()

        var data = Data(1, string)
        list.add(data)

    }



}

