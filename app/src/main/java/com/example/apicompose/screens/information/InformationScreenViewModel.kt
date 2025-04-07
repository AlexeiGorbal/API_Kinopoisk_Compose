package com.example.apicompose.screens.information

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
class InformationScreenViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    private val _film = MutableStateFlow<Film?>(null)
    val film: StateFlow<Film?>
        get() = _film.asStateFlow()

    fun getFilmById(filmId: Long) {
        viewModelScope.launch {
            _film.value = repository.getFilmById(filmId)
        }
    }
}