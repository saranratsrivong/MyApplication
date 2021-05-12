package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var list: ArrayList<Data>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)
        var delBut = itemView.findViewById<Button>(R.id.deleteButton)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.checkbox_item,parent,false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data_input = list.get(position).input

        holder.checkbox.text = "$data_input"
        //delBut.setOnClickListener { deleteItem() }

        // I try to delete select checkbox item but I can't ;-; whatever I do my best Thank you for first experience Test
        holder.checkbox.setOnClickListener{
            var getposition = position

            deleteItem(getposition)
        }

    }

    override fun getItemCount(): Int = list.size

    fun deleteItem(index: Int){
        list.removeAt(index)
        notifyDataSetChanged()
    }

    // Try to sort item
    fun setItems(items: List<Data>){
//        listData = items
//        notifyDataSetChanged()
    }
}

