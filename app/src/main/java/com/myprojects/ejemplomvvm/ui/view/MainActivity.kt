package com.myprojects.ejemplomvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.myprojects.ejemplomvvm.databinding.ActivityMainBinding
import com.myprojects.ejemplomvvm.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val userViewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.onCreate()

        userViewModel.userModel.observe(this, Observer { currentUser ->
            binding.tvName.text = currentUser.nombre
            binding.tvDni.text = currentUser.dni
            binding.tvApellido.text = currentUser.apellido
        })

        userViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
        binding.viewContent.setOnClickListener{
            userViewModel.randomUser()
        }
    }
}