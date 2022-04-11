package com.danielkelly.insurance_application

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val homeNlButton = findViewById<Button>(R.id.homeNlButton)


        homeNlButton.setOnClickListener {
            val intent = Intent(this,HomeNlActivity::class.java)
            startActivity(intent)
        }

        val phoneText = findViewById<TextView>(R.id.phoneText)

        phoneText.setOnClickListener{
            val mobileNumber = phoneText.text.toString().trim()
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "$mobileNumber")
            startActivity(dialIntent)
        }

    }


}