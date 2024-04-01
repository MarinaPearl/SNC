package ru.demchuk.snc.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.demchuk.snc.R
import ru.demchuk.snc.presentation.viewmodel.ProductViewModel
import ru.demchuk.snc.view.StateFragment


class HairFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ProductViewModel.opeAll()
        observeStateFragment()
        return ComposeView(requireContext()).apply {
            setContent {
                ListProduct()
            }
        }
    }

    private fun observeStateFragment() {
        lifecycleScope.launch {
            ProductViewModel.stateFragment.collect {
                when (it) {
                    is StateFragment.BottomSheetFragment -> {
                        withContext(Dispatchers.Main) {
                            requireActivity().supportFragmentManager
                                .beginTransaction()
                                .add(R.id.container, HairDialogFragment())
                                .commit();
                        }
                    }
                    is StateFragment.Empty -> {}
                }
            }
        }
    }
}