package com.danielkelly.insurance_application

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class HomeNlActivity : AppCompatActivity() {

    lateinit var typeOfPropertySpinner : Spinner
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_nl)

        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val postalCode = findViewById<EditText>(R.id.editTextTextPostal)
        val startDate =findViewById<EditText>(R.id.editTextDate)
        val fname = findViewById<EditText>(R.id.editFirstNameApplicant)
        val lname = findViewById<EditText>(R.id.editLastNameApplicant)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        val email = findViewById<EditText>(R.id.editTextEmailAddress)
        val adress = findViewById<EditText>(R.id.editTextAddress)
        val currentCompany = findViewById<EditText>(R.id.editCurrentInsurance)
        val replacementCost = findViewById<EditText>(R.id.editCostOfReplacement)
        val distanceFromHydrant = findViewById<EditText>(R.id.editDistanceFromHydrant)
        val distanceFromHall = findViewById<EditText>(R.id.editFromFireHall)
        val currentAdress = findViewById<EditText>(R.id.editYearsAtCurrentAdress)

        submitBtn.setOnClickListener {

            val emailBody = "\nPostal Code: " + postalCode.text + "\nStart Date :" +startDate.text + "\nFirst Name: "+ fname.text +"\nLast Name: "+ lname.text + "\nPhone Number:" + phone.text + "\nEmail: " + email.text + "\nAddress:" + adress.text + "\nCurrent Company: " + currentCompany.text + "\nReplacement Cost: $" + replacementCost.text  + "\nDistance From Hydrant: " + distanceFromHydrant.text +"\nDistance From Fire Hall: "+distanceFromHall.text + "\nYears At Current Address "+ currentAdress.text
            val  intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL,"recipient@example.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Quote")
            intent.putExtra(Intent.EXTRA_TEXT,emailBody)

            try {
                startActivity(Intent.createChooser(intent, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}