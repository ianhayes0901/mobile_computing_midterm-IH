package com.driuft.androidkotlindebugging.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.driuft.androidkotlindebugging.R
import android.widget.Toast

class RandomNumber : AppCompatActivity() {

    private val favoriteNumber: TextView get() = findViewById(R.id.favorite_number)
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)

        // Generate a random number between 1 and 9
        val number: Int = (1..9).random()

        favoriteNumber.text = "$number"
        val toastMessage = "Today's lucky number is $number!"
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}
