package edu.cvr.retrofitdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class CreateNewUserActivity : AppCompatActivity() {
    lateinit var viewModel: CreateNewUserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)

        initViewModel()
        createUserObservable()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateNewUserViewModel::class.java)

    }

    private fun createUserObservable(){
        viewModel.getCreateNewUserObservable().observe(this, Observer<UserResponse?> {
            if(it == null){
                Toast.makeText(this@CreateNewUserActivity,"failed to create new user..", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@CreateNewUserActivity,"Successfully created new user..", Toast.LENGTH_SHORT).show()
                finish()
            }

        })
    }
}