package com.myprojects.ejemplomvvm.data.network

import com.myprojects.ejemplomvvm.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(private val api:UserApiClient) {


    suspend fun getUsers():List<UserModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllUsers()
            response.body() ?: emptyList()
        }

    }
}