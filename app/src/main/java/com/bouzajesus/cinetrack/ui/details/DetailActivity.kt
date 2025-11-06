package com.bouzajesus.cinetrack.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bouzajesus.cinetrack.R
import com.bouzajesus.cinetrack.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}