package com.example.roomcronoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcronoapp.model.Cronos
import com.example.roomcronoapp.repository.CronosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CronosViewModel @Inject constructor(private val repository: CronosRepository) : ViewModel() {

    private val _cronosList = MutableStateFlow<List<Cronos>>(emptyList())
    val cronosList = _cronosList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCronos().collect { item ->
                if (item.isNullOrEmpty()) {
                    _cronosList.value = emptyList()
                } else {
                    _cronosList.value = item
                }

            }
        }
    }

    fun addCrono(cronos: Cronos) = viewModelScope.launch { repository.addCrono(cronos) }
    fun updateCrono(cronos: Cronos) = viewModelScope.launch { repository.updateCrono(cronos) }
    fun deleteCrono(cronos: Cronos) = viewModelScope.launch { repository.delete(cronos) }
}