package com.dawaiwaala.minimechanicserviceapp

class MechanicRepository {

    suspend fun getMechanics(): Result<List<Mechanic>> {

        return try {

            kotlinx.coroutines.delay(1500)

            val mechanics = listOf(

                Mechanic(
                    id = 1,
                    name = "AutoCare Garage",
                    rating = 4.8,
                    distance = "1.2 km",
                    location = "MG Road",
                    services = listOf(
                        "Oil Change",
                        "Brake Repair",
                        "Engine Repair"
                    ),
                    status = "Open",
                    address = "12 MG Road, New Delhi",
                    workingHours = "9:00 AM - 8:00 PM",
                    phone = "9876543210"
                ),

                Mechanic(
                    id = 2,
                    name = "Speed Motors",
                    rating = 4.5,
                    distance = "2.5 km",
                    location = "Connaught Place",
                    services = listOf(
                        "Tyre Repair",
                        "Battery",
                        "Car Service"
                    ),
                    status = "Open",
                    address = "45 Connaught Place, New Delhi",
                    workingHours = "8:00 AM - 7:00 PM",
                    phone = "9876501234"
                ),

                Mechanic(
                    id = 3,
                    name = "QuickFix Garage",
                    rating = 4.2,
                    distance = "3.8 km",
                    location = "Lajpat Nagar",
                    services = listOf(
                        "AC Repair",
                        "Oil Change",
                        "General Service"
                    ),
                    status = "Closed",
                    address = "78 Lajpat Nagar, New Delhi",
                    workingHours = "10:00 AM - 6:00 PM",
                    phone = "9812345678"
                ),

                Mechanic(
                    id = 4,
                    name = "City Car Care",
                    rating = 4.7,
                    distance = "4.1 km",
                    location = "Saket",
                    services = listOf(
                        "Engine Repair",
                        "Brake Repair",
                        "Car Wash"
                    ),
                    status = "Open",
                    address = "21 Saket Main Road, New Delhi",
                    workingHours = "9:00 AM - 9:00 PM",
                    phone = "9898989898"
                )
            )

            Result.success(mechanics)

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}