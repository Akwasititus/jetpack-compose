package composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun OriginalText(
    textName: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    color:  Color,
    onClickAction: () -> Unit = {}
){
    Text(
        text = textName,
        style = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.Bold, fontSize = fontSize
        ),
        color = color,
        modifier = modifier
            .clickable { onClickAction() }
    )

}