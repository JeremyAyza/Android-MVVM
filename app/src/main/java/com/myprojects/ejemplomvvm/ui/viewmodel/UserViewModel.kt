package com.myprojects.ejemplomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myprojects.ejemplomvvm.data.model.UserModel
import com.myprojects.ejemplomvvm.domain.GetUsersUseCase
import com.myprojects.ejemplomvvm.domain.GetRandomUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase : GetUsersUseCase,
    private val getRandomUserUseCase : GetRandomUserUseCase
    ): ViewModel() {

    val userModel = MutableLiveData<UserModel>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUsersUseCase()
            if (!result.isNullOrEmpty()){
                userModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomUser(){
        isLoading.postValue(true)
        val user = getRandomUserUseCase()
        if (user!=null){
            userModel.postValue(user!!)
        }
        isLoading.postValue(false)
    }


}