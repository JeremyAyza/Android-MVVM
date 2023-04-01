package com.myprojects.ejemplomvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProvider @Inject constructor() {
    var users:List<UserModel> = emptyList()

}