package com.example.apicompose.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicompose.repository.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFilmsViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {

    private val _films = MutableStateFlow<ListFilmsState?>(null)
    val films get() = _films.filterNotNull()

    init {
        viewModelScope.launch {
            _films.value = ListFilmsState(repository.loadFilms())
        }
    }
}