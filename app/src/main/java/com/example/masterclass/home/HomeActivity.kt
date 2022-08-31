package com.example.masterclass.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.masterclass.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.guessButton.setOnClickListener {}
    }
}
