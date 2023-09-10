package com.example.musicplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.databinding.ActivityMainBinding
import java.sql.Time
import java.util.*

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

        // set duration for slider value from:
        binding.sliderMain.valueTo = mediaPlayer.duration.toFloat()

        binding.txtRight.text = convertMillisToString(mediaPlayer.duration.toLong())

        //set timer:
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    binding.txtLeft.text = convertMillisToString(mediaPlayer.currentPosition.toLong())
                }
            }

        }, 1000, 1000)

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

    private fun convertMillisToString(duration: Long): String {
        val second = duration / 1000 % 60
        val minute = duration / (1000 * 60)

        return java.lang.String.format(Locale.US, "%02d:%02d", minute, second)
    }
}