package ru.demchuk.snc.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.demchuk.snc.R
import ru.demchuk.snc.di.RetrofitProvider
import ru.demchuk.snc.presentation.HairFragment
import ru.demchuk.snc.presentation.model.Product
import ru.demchuk.snc.view.StateFragment

object ProductViewModel : ViewModel() {
    private val productStateFlow  = MutableStateFlow<List<Product>?>(null)
    val _productStateFlow = productStateFlow

    private val _hairSetFlow  = MutableStateFlow<List<Product>?>(null)
    val hairSetFlow = _hairSetFlow

    private val _stateFragment = MutableStateFlow<StateFragment>(StateFragment.Empty)
    val stateFragment = _stateFragment

    fun opeAll() {
        val ret = RetrofitProvider()
        viewModelScope.launch {
            val productForHair = ret.get().getAllProductForHair()
            productStateFlow.value = productForHair
        }
    }

    fun openSets(product : Product) {
        val retrofit = RetrofitProvider()
        viewModelScope.launch {
            val productForHair = retrofit.get().getSets(product.input_brand, product.input_name)
            _hairSetFlow.value = productForHair
        }
    }

    fun openBottomSheet() {
        _stateFragment.value = StateFragment.BottomSheetFragment
    }

    fun closeBottomSheet() {
        _stateFragment.value = StateFragment.Empty
    }

}