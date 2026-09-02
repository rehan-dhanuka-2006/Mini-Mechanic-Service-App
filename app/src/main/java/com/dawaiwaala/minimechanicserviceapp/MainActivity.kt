package com.dawaiwaala.minimechanicserviceapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingLayout: LinearLayout
    private lateinit var errorLayout: LinearLayout
    private lateinit var errorText: TextView
    private lateinit var adapter: MechanicAdapter

    private val viewModel: MechanicViewModel by viewModels()
    private var allMechanics: List<Mechanic> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.mechanicRecyclerView)
        loadingLayout = findViewById(R.id.loadingLayout)
        errorLayout = findViewById(R.id.errorLayout)
        errorText = findViewById(R.id.errorText)

        adapter = MechanicAdapter(
            mutableListOf()
        ) { mechanic ->

            val intent = Intent(
                this,
                MechanicDetailActivity::class.java
            )

            intent.putExtra("mechanicId", mechanic.id)
            intent.putExtra("name", mechanic.name)
            intent.putExtra("rating", mechanic.rating)
            intent.putExtra("distance", mechanic.distance)
            intent.putExtra("location", mechanic.location)
            intent.putExtra(
                "services",
                mechanic.services.joinToString(", ")
            )
            intent.putExtra("status", mechanic.status)
            intent.putExtra("address", mechanic.address)
            intent.putExtra("workingHours", mechanic.workingHours)
            intent.putExtra("phone", mechanic.phone)

            startActivity(intent)
        }

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        recyclerView.adapter = adapter

        observeViewModel()
        viewModel.loadMechanics()
    }

    private fun observeViewModel() {

        viewModel.mechanics.observe(this) { mechanics ->

            adapter.updateData(mechanics)

            recyclerView.visibility = View.VISIBLE
            loadingLayout.visibility = View.GONE
            errorLayout.visibility = View.GONE
        }

        viewModel.isLoading.observe(this) { isLoading ->

            if (isLoading) {

                loadingLayout.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
                errorLayout.visibility = View.GONE

            } else {

                loadingLayout.visibility = View.GONE
            }
        }

        viewModel.error.observe(this) { error ->

            if (error != null) {

                errorText.text = error

                errorLayout.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
                loadingLayout.visibility = View.GONE

            } else {

                errorLayout.visibility = View.GONE
            }
        }
    }
}