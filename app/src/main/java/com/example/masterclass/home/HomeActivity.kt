package com.example.masterclass.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.masterclass.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
        observeViewModel()
        viewModel.startGame()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state -> render(state) }
    }

    private fun render(state: HomeState) {
        binding.currentGuess.text = state.currentGuess
        binding.triesLeftTextView.text = "Tries left: ${state.triesLeft}"
    }

    private fun setupClickListeners() {
        binding.guessButton.setOnClickListener {
            viewModel.guessClicked(binding.inputField.text.toString())
        }
    }
}
