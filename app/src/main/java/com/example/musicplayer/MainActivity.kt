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
    var isPlaying = true

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
        mediaPlayer = MediaPlayer.create(this, R.raw.besmellah_music)
        mediaPlayer.start()
        isPlaying = true

        binding.btnPlayPause.setImageResource(R.drawable.ic_pause)
    }

    private fun configureVolume() {
    }

    private fun goAfterMusic() {
    }

    private fun goBeforeMusic() {
    }

    private fun configureMusic() {
        if (isPlaying) {
            mediaPlayer.pause()
            binding.btnPlayPause.setImageResource(R.drawable.ic_play)
            isPlaying = false
        } else {
            mediaPlayer.start()
            binding.btnPlayPause.setImageResource(R.drawable.ic_pause)
            isPlaying = true
        }
    }
}