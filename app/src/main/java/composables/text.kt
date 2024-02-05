package composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun LightText(textName: String, fontSize: TextUnit, modifier: Modifier = Modifier, color:  Color){
    Text(
        text = textName,
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold, fontSize = fontSize
        ),
        color = color,
        //modifier = Modifier.padding(bottom = 16.dp)
    )
}