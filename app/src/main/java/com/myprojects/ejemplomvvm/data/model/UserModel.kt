package com.myprojects.ejemplomvvm.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(@SerializedName("nombre")val nombre:String, @SerializedName("apellido")val apellido:String, @SerializedName("dni") val dni:String) {


}