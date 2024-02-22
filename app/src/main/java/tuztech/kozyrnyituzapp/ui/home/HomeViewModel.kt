package tuztech.kozyrnyituzapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tuztech.kozyrnyituzapp.model.Barbershop
import tuztech.kozyrnyituzapp.service.BarbershopService

class HomeViewModel : ViewModel() {
    private val _barbershops = MutableLiveData<List<Barbershop>>()
    val barbershops: LiveData<List<Barbershop>> = _barbershops

    private val barbershopService: BarbershopService by lazy {
        Retrofit.Builder()
            .baseUrl("https://8d8d-93-127-110-156.ngrok-free.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BarbershopService::class.java)
    }

    init {
        loadBarbershops()
    }

    private fun loadBarbershops() {
        viewModelScope.launch {
            val response = barbershopService.getAllBarbershops()
            if (response.isSuccessful) {
                _barbershops.postValue(response.body())
            }
        }
    }
}