package com.arash.altafi.extensionfunction

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.arash.altafi.extensionfunction.test3.glide.ktx.load
import com.thuanpx.ktext.number.isTrue
import com.thuanpx.ktext.number.nullToZero
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        init()
    }

    private fun init() {
        //test 00
        img_test_1.loadUrl("https://arashaltafi.ir/arash.jpg")

        // test 0
        this.showToast("Arash Altafi")

        // test 1 => Library 1 => https://github.com/ThuanPx/KtExt
        btn_extension_function_1.setOnClickListener {
            test1()
        }

        // test 2 => Library 2 => https://github.com/AgustaRC/Android-Kotlin-Extensions
        btn_extension_function_2.setOnClickListener {
            test2()
        }

        // test 3 => Library 3 => https://github.com/champChayangkoon/Glide-KTX
        btn_extension_function_3.setOnClickListener {
            test3()
        }

        // test 4 => Library 4 => https://github.com/JoshHughes-Dev/kotlin-extensions
        btn_extension_function_4.setOnClickListener {
            test4()
        }

        // test 5 => Library 5 => https://github.com/Carleslc/kotlin-extensions
        btn_extension_function_5.setOnClickListener {
            test5()
        }

        // test 6 => Library 6 => https://github.com/radoyankov/kotlin-extensions
        btn_extension_function_6.setOnClickListener {
            test6()
        }

        // test 7 => Library 7 => https://github.com/Tarikul711/my-kotlin-utilities
        btn_extension_function_7.setOnClickListener {
            test7()
        }

        // test 8 => Library 8 => https://github.com/ravidsrk/kotlinextensions.com
        btn_extension_function_8.setOnClickListener {
            test8()
        }

    }

    private fun ImageView.loadUrl(url : String) {
        Glide.with(this@MainActivity).load(url).into(this)
    }

    private fun Context.showToast(text : String, duration : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this , text , duration).show()
    }

    private fun test1() {
        var number : Int ?= null
        println(number.nullToZero())

        number = 1
        println(number.isTrue())
    }

    private fun test2() {
        //test 2
    }

    @SuppressLint("CheckResult")
    private fun test3() {
        //test 3
        img_test_2.load("https://arashaltafi.ir/Social_Media/story-01.jpg") {
            transform(CircleCrop())
        }

    }

    private fun test4() {
        //test 3
    }

    private fun test5() {
        // test 5
    }

    private fun test6() {
        // test 6
    }

    private fun test7() {
        // test 7
    }

    private fun test8() {
        // test 8
    }

}