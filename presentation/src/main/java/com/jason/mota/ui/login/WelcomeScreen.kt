package com.jason.mota.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jason.mota.R

@ExperimentalAnimationApi
@Composable
fun WelcomeScreen(navController: NavController?) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black_blue))
    ) {
        val (imageLeftTop, imageRightTop, imageLeftBot, centerView, descriptionView, description, btnGetStarted) = createRefs()
        Image(
            painterResource(id = R.drawable.gradient_blue),
            contentDescription = null,
            modifier = Modifier
                .size(
                    dimensionResource(id = R.dimen.circle_size_small),
                    dimensionResource(id = R.dimen.circle_size_small)
                )
                .constrainAs(imageLeftTop) {
                    start.linkTo(parent.absoluteLeft, margin = (-60).dp)
                    top.linkTo(parent.top, margin = 60.dp)
                }
        )
        Image(
            painterResource(id = R.drawable.gradient_blue),
            contentDescription = null,
            modifier = Modifier
                .size(
                    dimensionResource(id = R.dimen.circle_size_medium),
                    dimensionResource(id = R.dimen.circle_size_medium)
                )
                .constrainAs(imageRightTop) {
                    start.linkTo(parent.absoluteRight, margin = (-70).dp)
                    top.linkTo(parent.top, margin = 200.dp)
                }
        )
        Image(
            painterResource(id = R.drawable.gradient_light_blue),
            contentDescription = null,
            modifier = Modifier
                .size(
                    dimensionResource(id = R.dimen.circle_size_medium),
                    dimensionResource(id = R.dimen.circle_size_medium)
                )
                .constrainAs(imageLeftBot) {
                    start.linkTo(parent.absoluteLeft, margin = (-50).dp)
                    top.linkTo(parent.bottom, margin = (-70).dp)
                }
        )
        Column(
            modifier = Modifier
                .fillMaxHeight(0.35f)
                .fillMaxWidth()
                .constrainAs(centerView) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 60.sp,
                color = Color.White,
                fontWeight = FontWeight.Black,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .constrainAs(descriptionView) {
                    start.linkTo(parent.start, 34.dp)
                    top.linkTo(centerView.bottom)
                },
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = stringResource(id = R.string.started_title),
                fontSize = dimensionResource(id = R.dimen.font_size_huge_x).value.sp,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.started_description),
                fontSize = dimensionResource(id = R.dimen.font_size_very_huge).value.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
                .constrainAs(btnGetStarted) {
                    start.linkTo(parent.start)
                    top.linkTo(descriptionView.bottom, 20.dp)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    navController?.navigate(NavigationDestinations.loginScreen)
                },
                modifier = Modifier
                    .padding(35.dp, 0.dp)
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(40.dp)),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.black_blue)
                )
            ) {
                GradientTextView(stringResource(id = R.string.started_btn))
            }
        }
    }
}

@Composable
fun GradientTextView(title: String) {
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
                text = title,
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

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WelcomeScreen(null)
}