package edu.cvr.retrofitdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rva: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rv = findViewById<RecyclerView>(R.id.recyclerView)
        var sb = findViewById<Button>(R.id.search_button)
        var set = findViewById<EditText>(R.id.searchEditText)
        initRecyclerView(rv)
        initViewModel()
        searchUser(sb, set)
    }

    private fun searchUser(sb:Button,set: EditText) {
        sb.setOnClickListener(){
            if(!TextUtils.isEmpty(set.text.toString())){
                viewModel.searchUser(set.text.toString())
            }else{
                 viewModel.getUsersList()
            }
        }
    }

    private fun initRecyclerView(rv: RecyclerView){
        rv.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            rva = RecyclerViewAdapter()
            adapter = rva
        }

    }
    fun initViewModel(){

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getUserListObservable().observe(this, Observer<UserList>{
            if(it==null){
                Toast.makeText(this@MainActivity,"no result found..", Toast.LENGTH_SHORT).show()
            }else{
                rva.userList = it.data.toMutableList()
                rva.notifyDataSetChanged()
            }
        })
        viewModel.getUsersList()
    }

}