package tuztech.kozyrnyituzapp.ui.shopping_cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoppingCartViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the shopping cart fragment"
    }
    val text: LiveData<String> = _text
}