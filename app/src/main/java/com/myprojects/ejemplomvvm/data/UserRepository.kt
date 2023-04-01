package com.myprojects.ejemplomvvm.data

import com.myprojects.ejemplomvvm.data.model.UserModel
import com.myprojects.ejemplomvvm.data.model.UserProvider
import com.myprojects.ejemplomvvm.data.network.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(private val api : UserService, private val userProvider: UserProvider){


    suspend fun getAllUsers():List<UserModel>{
        val response = api.getUsers()
        userProvider.users = response
        return response
    }
}