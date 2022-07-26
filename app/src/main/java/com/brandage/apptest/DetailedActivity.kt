package com.brandage.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brandage.apptest.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailedBinding.inflate(layoutInflater)

        binding.modelName.text = intent.getStringExtra("NAME")
        binding.modelDose.text = intent.getStringExtra("DOSE")
        binding.modelStrength.text = intent.getStringExtra("STRENGTH")
    }
}