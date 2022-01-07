package com.arash.altafi.extensionfunction

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    lateinit var img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img_test)

        //test 1
        img.loadUrl("https://arashaltafi.ir/arash.jpg")

        // test 2
        this.showToast("Arash Altafi")
    }

    private fun ImageView.loadUrl(url : String) {
        Glide.with(this@MainActivity).load(url).into(this)
    }

    private fun Context.showToast(text : String, duration : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this , text , duration).show()
    }

}