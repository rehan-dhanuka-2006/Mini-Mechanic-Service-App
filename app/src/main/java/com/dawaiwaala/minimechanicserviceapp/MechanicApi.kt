package com.dawaiwaala.minimechanicserviceapp

import retrofit2.http.GET

interface MechanicApi {

    @GET("mechanics")
    suspend fun getMechanics(): List<Mechanic>
}