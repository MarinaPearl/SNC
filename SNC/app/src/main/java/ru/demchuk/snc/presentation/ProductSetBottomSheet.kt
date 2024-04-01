package ru.demchuk.snc.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.demchuk.snc.presentation.model.Product
import ru.demchuk.snc.presentation.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductSetBottomSheet (product: Product) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded,
        skipHalfExpanded = true
    )
    val composableScope = rememberCoroutineScope()

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == ModalBottomSheetValue.Hidden) {
            ProductViewModel.closeBottomSheet()
        }
    }

    val screenState by ProductViewModel.hairSetFlow.collectAsState()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        sheetBackgroundColor = Color.Transparent,
        scrimColor = Color.Transparent,
        sheetContent = {
            ProductSet(product, screenState)
        },
        content = {}
    )


}

@Composable
fun ProductSet(product: Product, listProduct : List<Product>?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(Color(200, 188, 171))) {
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .width(100.dp)
                    .height(90.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = product.input_urlImage),
                contentDescription = null
            )
        }
            Spacer(modifier = Modifier.height(20.dp))
            listProduct?.let {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    items(it,
                        itemContent = { item ->
                            Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        painter = rememberAsyncImagePainter(item.input_urlImage),
                                        contentDescription = "gfg image",
                                        modifier = Modifier
                                            .height(140.dp)
                                            .width(140.dp)
                                            .wrapContentWidth()
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = item.input_name,
                                        fontSize = TextUnit(value = 20f, type = TextUnitType.Sp),
                                        textAlign = TextAlign.Center,
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                }
                            }
                        })
                }
            }
    }
}