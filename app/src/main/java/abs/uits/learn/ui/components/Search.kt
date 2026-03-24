package abs.uits.learn.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Search(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    TextField(
        value = searchText,
        onValueChange = { newText ->
            searchText = newText
        },
        modifier
            .fillMaxWidth(0.9f)
            .height(50.dp)
            .clip(RoundedCornerShape(15.dp)),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                tint = Color(0xFF000000)
            )
        },
        placeholder = {
            Text(text = "Search Store", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF2F3F2),
            unfocusedContainerColor = Color(0xFFF2F3F2),
            disabledContainerColor = Color.Black,
            errorContainerColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        )
    )
}