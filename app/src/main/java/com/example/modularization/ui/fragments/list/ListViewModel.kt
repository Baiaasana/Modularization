package com.example.modularization.ui.fragments.list


import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.backend.data.UserModel
import com.example.backend.repository.UserRepository
import com.example.backend.use_case.UserUseCase
import com.example.modularization.App

class ListViewModel(private val useCase: UserUseCase) : ViewModel() {

    private val _list = MutableLiveData<List<UserModel>>()
    val list: LiveData<List<UserModel>> = _list

    fun getList() {
        _list.value = useCase.invoke()
    }

    fun updateListItems(item: UserModel) {
        val list = _list.value
        list!!.find { findUser ->
            findUser.id == item.id
        }!!.apply {
            username = item.username
            firstName = item.firstName
            lastName = item.lastName
            age = item.age
        }
        _list.value = list!!
    }

    companion object {

        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val useCase = App().useCase
                ListViewModel(
                    useCase = useCase
                )
            }
        }
    }
}