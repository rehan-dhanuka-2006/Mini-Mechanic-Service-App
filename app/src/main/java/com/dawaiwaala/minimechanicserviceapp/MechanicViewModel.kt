package com.dawaiwaala.minimechanicserviceapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MechanicViewModel : ViewModel() {

    private val repository = MechanicRepository()

    private val _mechanics = MutableLiveData<List<Mechanic>>()
    val mechanics: LiveData<List<Mechanic>> = _mechanics

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun loadMechanics() {

        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {

            val result = repository.getMechanics()

            result
                .onSuccess { data ->
                    _mechanics.value = data
                }
                .onFailure { exception ->
                    _error.value =
                        exception.message ?: "Something went wrong"
                }

            _isLoading.value = false
        }
    }
}