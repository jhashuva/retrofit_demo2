package edu.cvr.retrofitdemo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_list, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtViewName = view.findViewById<TextView>(R.id.textViewName)
        val txtViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val txtViewViewStats = view.findViewById<TextView>(R.id.textViewStats)
        fun bind(data: User){
            txtViewName.text = data.name
            txtViewEmail.text = data.email
            txtViewViewStats.text = data.status
        }

    }
}