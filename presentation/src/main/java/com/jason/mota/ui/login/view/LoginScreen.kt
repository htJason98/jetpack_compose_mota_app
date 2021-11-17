package com.jason.mota.ui.login.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jason.mota.R
import com.jason.mota.component.GradientButton
import com.jason.mota.component.OutlineButtonImage
import com.jason.mota.ui.navigation.NavigationDestinations

@Composable
fun LoginScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .background(color = colorResource(id = R.color.black_blue))
            .fillMaxSize()
    ) {
        val (imageTopRight,
            imageTopLeft,
            imageBotRight,
            description,
            btnContinue,
            apiLogin,
            termOfUse
        ) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .constrainAs(imageTopRight) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, 40.dp)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painterResource(id = R.drawable.gradient_orange_red),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp, 60.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .constrainAs(imageTopLeft) {
                    top.linkTo(imageTopRight.bottom)
                    start.linkTo(parent.start, 30.dp)
                },
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painterResource(id = R.drawable.gradient_blue_pink),
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp, 220.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .constrainAs(imageBotRight) {
                    top.linkTo(imageTopLeft.bottom)
                    start.linkTo(parent.start, margin = 30.dp)
                },
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painterResource(id = R.drawable.gradient_blue_green),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp, 80.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)
                .constrainAs(description) {
                    top.linkTo(imageTopLeft.bottom)
                    start.linkTo(parent.start, margin = 35.dp)
                },
            verticalArrangement = Arrangement.Bottom
        ) {
            Description()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.13f)
                .constrainAs(btnContinue) {
                    start.linkTo(parent.start)
                    top.linkTo(imageBotRight.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            GradientButton(
                onClick = { navController.navigate(NavigationDestinations.registrationScreen) },
                text = stringResource(id = R.string.login_btn_email)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(apiLogin) {
                    top.linkTo(btnContinue.bottom, 14.dp)
                    start.linkTo(btnContinue.start)
                },
            horizontalArrangement = Arrangement.Center
        ) {
            OutlineButtonImage(
                onClick = {
                   //login with google api
                },
                resImageId = R.drawable.ic_google
            )
            Spacer(modifier = Modifier.width(16.dp))
            OutlineButtonImage(
                onClick = {
                    //login with facebook api
                },
                resImageId = R.drawable.ic_facebook
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(termOfUse) {
                    top.linkTo(apiLogin.bottom, margin = 30.dp)
                    start.linkTo(apiLogin.start)
                },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.login_term_of_use),
                fontSize = dimensionResource(id = R.dimen.font_size_medium).value.sp,
                color = Color.LightGray,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Description() {
    Text(
        text = stringResource(id = R.string.login_description),
        fontSize = dimensionResource(id = R.dimen.font_size_very_huge).value.sp,
        color = Color.White,
        fontWeight = FontWeight.ExtraBold,
        lineHeight = 40.sp
    )
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    LoginScreen(rememberNavController())
}