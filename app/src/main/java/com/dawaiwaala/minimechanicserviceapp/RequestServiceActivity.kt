package com.dawaiwaala.minimechanicserviceapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RequestServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_request_service)

        val garageNameText =
            findViewById<TextView>(R.id.garageNameText)

        val customerName =
            findViewById<EditText>(R.id.customerName)

        val phoneNumber =
            findViewById<EditText>(R.id.phoneNumber)

        val vehicleNumber =
            findViewById<EditText>(R.id.vehicleNumber)

        val serviceSpinner =
            findViewById<Spinner>(R.id.serviceSpinner)

        val problemDescription =
            findViewById<EditText>(R.id.problemDescription)

        val submitButton =
            findViewById<Button>(R.id.submitRequestButton)

        val garageName =
            intent.getStringExtra("garageName")
                ?: "Selected Garage"

        val servicesString =
            intent.getStringExtra("services")
                ?: ""

        garageNameText.text =
            "Request Service at $garageName"

        val serviceList =
            if (servicesString.isNotEmpty()) {
                servicesString.split(", ")
            } else {
                listOf(
                    "General Service",
                    "Oil Change",
                    "Brake Repair",
                    "Engine Repair"
                )
            }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            serviceList
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        serviceSpinner.adapter = adapter

        submitButton.setOnClickListener {

            val name =
                customerName.text.toString().trim()

            val phone =
                phoneNumber.text.toString().trim()

            val vehicle =
                vehicleNumber.text.toString().trim()

            val problem =
                problemDescription.text.toString().trim()

            if (name.isEmpty() ||
                phone.isEmpty() ||
                vehicle.isEmpty() ||
                problem.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val selectedService =
                serviceSpinner.selectedItem.toString()

            Toast.makeText(
                this,
                "Service request submitted successfully!\n" +
                        "Service: $selectedService",
                Toast.LENGTH_LONG
            ).show()

            customerName.text.clear()
            phoneNumber.text.clear()
            vehicleNumber.text.clear()
            problemDescription.text.clear()
        }
    }
}