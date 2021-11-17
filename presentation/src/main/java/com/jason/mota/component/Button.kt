package com.jason.mota.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jason.mota.R

@Composable
fun GradientButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .padding(35.dp, 0.dp)
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(40.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.black_blue)
        )
    ) {
        GradientTextView(text)
    }
}

@Composable
fun OutlineButtonImage(
    onClick: () -> Unit,
    resImageId: Int
) {
    OutlinedButton(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.black_blue)),
        modifier = Modifier
            .size(120.dp, 40.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
    ) {
        Image(
            painterResource(id = resImageId),
            contentDescription = null
        )
    }
}

@Composable
fun BackButton(
    onClick: () -> Unit
) {
    Image(
        painterResource(id = R.drawable.ic_caret_left),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp, 40.dp)
            .clickable { onClick() }
    )
}