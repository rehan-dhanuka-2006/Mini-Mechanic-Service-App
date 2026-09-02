package com.dawaiwaala.minimechanicserviceapp

data class Mechanic(
    val id: Int,
    val name: String,
    val rating: Double,
    val distance: String,
    val location: String,
    val services: List<String>,
    val status: String,
    val address: String,
    val workingHours: String,
    val phone: String
)
