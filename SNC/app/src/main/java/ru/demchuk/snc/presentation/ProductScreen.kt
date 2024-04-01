package ru.demchuk.snc.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import ru.demchuk.snc.R
import ru.demchuk.snc.presentation.model.Product
import ru.demchuk.snc.presentation.viewmodel.ProductViewModel


@Composable
fun ListProduct() {
    val state by ProductViewModel._productStateFlow.collectAsState()
   if (state != null) {
       val listProducts = state
       Box(
           modifier = Modifier
               .fillMaxSize()
               .navigationBarsPadding()
               .paint(
                   painterResource(id = R.drawable.start),
                   contentScale = ContentScale.FillBounds
               )
       ) {
           LazyColumn(
               modifier = Modifier
                   .padding(top = 10.dp)
                   .navigationBarsPadding(),
               verticalArrangement = Arrangement.spacedBy(10.dp)
           ) {
               if (listProducts != null) {
                   items(items = listProducts) {
                       ProductContent(it, ProductViewModel::openBottomSheet)
                   }
               }
           }
       }
   }
}

@Composable
fun ProductContent(product: Product, openBottomSheet: () -> Unit) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color(168, 141, 138), RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable { openBottomSheet() }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
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
            Column(
                modifier = Modifier.padding(start = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                Text(
                    text = product.input_name,
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 20.sp,
                )

                Text(
                    text = product.input_brand,
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontSize = 15.sp,
                )

                Text(
                    text = product.input_description,
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2,
                    fontSize = 15.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewListProduct() {


}