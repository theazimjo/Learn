package abs.uits.learn.ui.components

import abs.uits.learn.R
import abs.uits.learn.domain.model.Product
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProductItem(modifier: Modifier = Modifier, products: Product) {
    Card(
        modifier
            .width(170.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(15.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(15.dp),

            ) {
            AsyncImage(
                model = products.thumbnail,
                contentDescription = "Rasm",
                modifier.height(140.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier.height(5.dp))
            Text(
                text = products.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Spacer(modifier.height(5.dp))
            Row(
                modifier.fillMaxWidth(),
            ) {
                Text(text = "${products.weight}", fontSize = 9.sp)
                Text(text = products.brand, fontSize = 9.sp)
            }
            Spacer(modifier.height(8.dp))

            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${products.price}")
                Button(
                    onClick = {},
                    modifier
                        .width(60.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(17.dp),
                ) {
                    Image(painter = painterResource(R.drawable.plus), contentDescription = "")
                }
            }

        }

    }
}