package tuztech.kozyrnyituzapp.ui.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrdersViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the orders fragment"
    }
    val text: LiveData<String> = _text
}