package com.example.masterclass.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState> = _state

    fun startGame() {
        viewModelScope.launch {
            while (true) {
                val newState = generateState()
                _state.value = newState
                delay(800)
            }
        }
    }

    fun guessClicked(text: String) {
        _state.value = HomeState(
            isLoading = false,
            currentGuess = "A _ A _ _",
            triesLeft = 4,
        )
    }

    private fun generateState(): HomeState {
        return HomeState(
            isLoading = Random().nextBoolean(),
            currentGuess = "A".repeat((0..10).random()),
            triesLeft = (0..10).random(),
        )
    }
}
