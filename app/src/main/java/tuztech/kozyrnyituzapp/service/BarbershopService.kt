package tuztech.kozyrnyituzapp.service

import retrofit2.Response
import retrofit2.http.GET
import tuztech.kozyrnyituzapp.model.Barbershop

interface BarbershopService {
    @GET("/barbershop")
    suspend fun getAllBarbershops(): Response<List<Barbershop>>
}