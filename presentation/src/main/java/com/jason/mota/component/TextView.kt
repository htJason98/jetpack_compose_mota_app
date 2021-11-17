package com.jason.mota.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jason.mota.R

@Composable
fun GradientTextView(content: String) {
    ConstraintLayout {
        val (image, text) = createRefs()
        Image(
            painterResource(id = R.drawable.gradient_blue_pink),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp))
                .height(50.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .constrainAs(text) {
                    top.linkTo(parent.top)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = content,
                fontSize = dimensionResource(id = R.dimen.font_size_big).value.sp,
                color = Color.White,
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.margin_small))
            )
        }
    }
}

@Composable
fun TextViewScreenTitle(content: String) {
    Text(
        text = content,
        fontSize = dimensionResource(id = R.dimen.font_size_very_huge).value.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
    )
}

@Composable
fun TextViewTitle(content: String) {
    Text(
        text = content,
        fontSize = dimensionResource(id = R.dimen.font_size_huge_xs).value.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
    )
}

@Composable
fun TextViewRegular(content: String) {
    Text(
        text = content,
        fontSize = dimensionResource(id = R.dimen.font_size_big).value.sp,
        color = Color.White,
    )
}

@Composable
fun TextViewRegularMedium(content: String) {
    Text(
        text = content,
        fontSize = dimensionResource(id = R.dimen.font_size_medium).value.sp,
        color = Color.White,
    )
}