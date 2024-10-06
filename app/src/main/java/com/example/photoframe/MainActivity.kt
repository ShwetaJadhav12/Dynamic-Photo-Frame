package com.example.photoframe

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var image:ImageView
    var names= arrayOf("MS Dhoni","Virat Kohli","Rohit Sharma","Gautam Gambhir")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var current=0
        val prev=findViewById<ImageButton>(R.id.imgprev)
        val next=findViewById<ImageButton>(R.id.imgnext)
        val text=findViewById<TextView>(R.id.display)

        prev.setOnClickListener {
            val currentIdString = "pic$current"
            val currentIdInt = this.resources.getIdentifier(currentIdString, "id", packageName)
            val currentImage = findViewById<ImageView>(currentIdInt)

            current = (4 + current - 1) % 4
            val imgToShowIdString = "pic$current"
            val imgToShowIdInt = this.resources.getIdentifier(imgToShowIdString, "id", packageName)
            val imageToShow = findViewById<ImageView>(imgToShowIdInt)

            currentImage.alpha = 0F
            imageToShow.alpha = 1F
            text.text=names[current]
        }
        next.setOnClickListener {

            val currentIdString = "pic$current"
            val currentIdInt = this.resources.getIdentifier(currentIdString, "id", packageName)
            val currentImage = findViewById<ImageView>(currentIdInt)
            current = (4 + current + 1) % 4
            val imgToShowIdString = "pic$current"
            val imgToShowIdInt = this.resources.getIdentifier(imgToShowIdString, "id", packageName)
            val imageToShow = findViewById<ImageView>(imgToShowIdInt)

            currentImage.alpha = 0F
            imageToShow.alpha = 1F
            text.text=names[current]

        }




    }
}