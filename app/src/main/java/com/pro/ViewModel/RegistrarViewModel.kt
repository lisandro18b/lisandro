package com.pro.ViewModel

import androidx.lifecycle.ViewModel
import com.pro.Model.User

class RegistrarViewModel: ViewModel() {

    fun validar(user: User): Boolean {
        return user.name != null || user.pass != null
    }
}