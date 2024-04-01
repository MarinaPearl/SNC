package ru.demchuk.snc.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.demchuk.snc.R
import ru.demchuk.snc.presentation.HairDialogFragment
import ru.demchuk.snc.presentation.HairFragment
import ru.demchuk.snc.presentation.ListProduct
import ru.demchuk.snc.presentation.NavigatorHair
import ru.demchuk.snc.presentation.viewmodel.ProductViewModel


class ListProduct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_list_product)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, HairFragment())
            .commit();
    }
}