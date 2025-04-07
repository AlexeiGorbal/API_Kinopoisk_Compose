package com.example.apicompose.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicompose.domain.Film
import com.example.apicompose.domain.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListFilmsViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    private val _films = MutableStateFlow<List<Film>?>(null)
    val films: StateFlow<List<Film>?>
        get() = _films.asStateFlow()

    init {
        viewModelScope.launch {
            _films.value = repository.loadFilms()
        }
    }
}