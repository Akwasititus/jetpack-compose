package composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harkerthon.ui.theme.HarkerthonTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    strokeWidth: Int = 2,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            autoCorrect = true,
            capitalization = KeyboardCapitalization.Words,
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.Black,
            containerColor = Color.Transparent
        ),
        visualTransformation = visualTransformation,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 20.dp, top = 10.dp)
            .border(
                width = strokeWidth.dp,
                color = Color(0xFF22577A),
                shape = RoundedCornerShape(40.dp)
            )
    )
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    var email by remember { mutableStateOf("") }
    HarkerthonTheme {
        Surface (color = Color(0xFF80ED99)){
            CustomTextField(
                value = email,
                strokeWidth = 3,
                label = "email",
                keyboardType = KeyboardType.Email,
                onValueChange = { email = it },
            )
        }
    }
}