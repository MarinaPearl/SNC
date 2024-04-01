package ru.demchuk.snc.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import ru.demchuk.snc.presentation.model.Product
import ru.demchuk.snc.presentation.viewmodel.ProductViewModel


class HairDialogFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ProductViewModel.openSets(Product(input_id = 21,
            input_urlImage = "https://pcdn.goldapple.ru/p/p/19760300551/web/696d67416464338dad79ed723f4edfullhd.webp" ,
            input_brand = "LIKATO PROFESSIONAL сolorito color protection hair balm" ,
            input_name = "БАЛЬЗАМ ДЛЯ ОКРАШЕННЫХ ВОЛОС" ,
            input_description =  "",
            input_typeProblem = ""))
        return ComposeView(requireContext()).apply {
            setContent {
                ProductSetBottomSheet( Product(input_id = 21,
                input_urlImage = "https://pcdn.goldapple.ru/p/p/19760300551/web/696d67416464338dad79ed723f4edfullhd.webp" ,
                input_brand = "LIKATO PROFESSIONAL сolorito color protection hair balm" ,
                input_name = "БАЛЬЗАМ ДЛЯ ОКРАШЕННЫХ ВОЛОС" ,
                input_description =  "",
                input_typeProblem = ""))
            }
        }
    }
}