package com.example.apicompose.screens.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicompose.repository.FilmRepository
import com.example.apicompose.screens.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InformationScreenViewModel @Inject constructor(
    private val repository: FilmRepository
) : ViewModel() {

    private val _film = MutableStateFlow<Film?>(null)
    val film get() = _film.filterNotNull()

    fun getFilmById(filmId: Long) {
        viewModelScope.launch {
            _film.value = repository.getFilmById(filmId)
        }
    }
}