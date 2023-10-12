package com.driuft.androidkotlindebugging.ui

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.driuft.androidkotlindebugging.R


class PlaySoundActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_sound)

        mediaPlayer = MediaPlayer.create(this, R.raw.fanfare_trumpets)
        mediaPlayer.isLooping = false
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}
