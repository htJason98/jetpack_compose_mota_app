package com.jason.mota.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.jason.mota.R

@Composable
fun CustomTextField(
    defaultValue: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    keyboardActions: KeyboardActions,
    focusRequester: FocusRequester,
) {
    var transformation by remember { mutableStateOf(VisualTransformation.None) }
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = colorResource(id = R.color.black_blue),
            textColor = Color.LightGray
        ),
        visualTransformation = transformation,
        keyboardActions = keyboardActions,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = keyboardType
        ),
        modifier = Modifier
            .fillMaxWidth(0.83f)
            .onFocusChanged {
                if (it.isFocused && value == defaultValue) {
                    onValueChange("")
                    if (keyboardType == KeyboardType.Password) {
                        transformation = PasswordVisualTransformation()
                    }
                } else if (value.isEmpty()) {
                    onValueChange(defaultValue)
                    transformation = VisualTransformation.None
                }
            }
            .focusRequester(focusRequester)
    )
}