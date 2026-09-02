package com.dawaiwaala.minimechanicserviceapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class MechanicDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mechanic_detail)

        val detailName = findViewById<TextView>(R.id.detailName)
        val detailRating = findViewById<TextView>(R.id.detailRating)
        val detailStatus = findViewById<TextView>(R.id.detailStatus)
        val detailAddress = findViewById<TextView>(R.id.detailAddress)
        val detailServices = findViewById<TextView>(R.id.detailServices)
        val detailHours = findViewById<TextView>(R.id.detailHours)
        val detailPhone = findViewById<TextView>(R.id.detailPhone)

        val requestServiceButton =
            findViewById<Button>(R.id.requestServiceButton)

        val name = intent.getStringExtra("name") ?: "Unknown Garage"
        val rating = intent.getDoubleExtra("rating", 0.0)
        val status = intent.getStringExtra("status") ?: "Unknown"
        val address = intent.getStringExtra("address") ?: "Not available"
        val services = intent.getStringExtra("services") ?: "Not available"
        val workingHours =
            intent.getStringExtra("workingHours") ?: "Not available"
        val phone = intent.getStringExtra("phone") ?: "Not available"

        detailName.text = name
        detailRating.text = "⭐ Rating: $rating"
        detailStatus.text = "Status: $status"
        detailAddress.text = "📍 Address: $address"
        detailServices.text = "🔧 Services: $services"
        detailHours.text = "🕒 Working Hours: $workingHours"
        detailPhone.text = "📞 Phone: $phone"

        requestServiceButton.setOnClickListener {

            val intent = Intent(
                this,
                RequestServiceActivity::class.java
            )

            intent.putExtra("garageName", name)
            intent.putExtra("services", services)

            startActivity(intent)
        }
    }
}