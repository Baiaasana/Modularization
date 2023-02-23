package com.example.modularization

import android.app.Application
import com.example.backend.repository.UserRepository
import com.example.backend.use_case.UserUseCase

class App: Application() {

    val useCase: UserUseCase by lazy { UserUseCase(UserRepository()) }

}