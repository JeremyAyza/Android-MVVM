package com.myprojects.ejemplomvvm.domain

import com.myprojects.ejemplomvvm.data.UserRepository
import com.myprojects.ejemplomvvm.data.model.UserModel
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository : UserRepository){
    suspend operator fun invoke():List<UserModel>? = repository.getAllUsers()

}

