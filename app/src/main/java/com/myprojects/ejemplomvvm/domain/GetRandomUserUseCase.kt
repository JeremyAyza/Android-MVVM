package com.myprojects.ejemplomvvm.domain

import android.util.Log
import android.widget.Toast
import com.myprojects.ejemplomvvm.data.model.UserModel
import com.myprojects.ejemplomvvm.data.model.UserProvider
import javax.inject.Inject

class GetRandomUserUseCase @Inject constructor( private val userProvider: UserProvider){


  operator fun invoke():UserModel?{

    val users= userProvider.users
    Log.d("MiApp", "User random generado: $userProvider")
    if (!users.isNullOrEmpty()){
      val randomNumber = (users.indices).random()
      val userRandom = users[randomNumber]

      Log.d("MiApp", "User random generado: $userRandom")
      return users[randomNumber]
    }
    Log.d("MiApp", "No se encontraron usuarios")
    return null
  }

}