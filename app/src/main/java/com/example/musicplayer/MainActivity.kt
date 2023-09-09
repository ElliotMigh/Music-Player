package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //create binding:
    lateinit var binding: ActivityMainBinding
    //create media player:
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //prepare music:
        prepareMusic()

        //click on btn play and pause:
        binding.btnPlayPause.setOnClickListener { configureMusic() }
        //click on btn go before:
        binding.btnGoBefore.setOnClickListener { goBeforeMusic() }
        //click on btn go after:
        binding.btnGoAfter.setOnClickListener { goAfterMusic() }
        //click on btn volume on off:
        binding.btnVolumeOfOn.setOnClickListener { configureVolume() }
    }

    private fun prepareMusic() {
    }

    private fun configureVolume() {
    }

    private fun goAfterMusic() {
    }

    private fun goBeforeMusic() {
    }

    private fun configureMusic() {
    }
}