package com.example.masterclass.home

data class HomeState(
    val isLoading: Boolean,
    val currentGuess: String,
    val triesLeft: Int,
)
