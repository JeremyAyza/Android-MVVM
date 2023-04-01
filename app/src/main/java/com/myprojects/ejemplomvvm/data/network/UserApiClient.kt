package com.myprojects.ejemplomvvm.data.network

import com.myprojects.ejemplomvvm.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("/api/usuario/")
    suspend fun getAllUsers():Response<List<UserModel>>

}