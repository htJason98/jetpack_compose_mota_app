package com.jason.mota.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jason.mota.R
import com.jason.mota.common.Constants
import com.jason.mota.component.CustomTextField
import com.jason.mota.component.GradientButton
import com.jason.mota.ui.navigation.NavigationDestinations
import kotlinx.coroutines.launch

@Composable
fun RegistrationScreen(navController: NavController) {
    var username by remember { mutableStateOf(Constants.USER_NAME) }
    var email by remember { mutableStateOf(Constants.EMAIL) }
    var password by remember { mutableStateOf(Constants.PASSWORD) }
    val usernameFocusRequester = remember { FocusRequester() }
    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black_blue))
    ) {
        val (btnBack, title, edtUsername, edtEmail, edtPassword, btnSignUp, tvAlready) = createRefs()
        Image(
            painterResource(id = R.drawable.ic_caret_left),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp, 40.dp)
                .constrainAs(btnBack) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                }
                .clickable {
                    scope.launch {
                        navController?.popBackStack()
                    }
                }
        )
        Text(
            text = stringResource(id = R.string.sign_up_title),
            fontSize = dimensionResource(id = R.dimen.font_size_very_huge_x).value.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(btnBack.bottom, margin = 12.dp)
                start.linkTo(btnBack.start, margin = 12.dp)
            },
            fontFamily = FontFamily.Default
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(edtUsername) {
                    top.linkTo(title.bottom, margin = 24.dp)
                    start.linkTo(title.start)
                }
        ) {
            CustomTextField(
                defaultValue = Constants.USER_NAME,
                value = username,
                onValueChange = { username = it },
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text,
                keyboardActions = KeyboardActions(onNext = { emailFocusRequester.requestFocus() }),
                focusRequester = usernameFocusRequester
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(edtEmail) {
                    top.linkTo(edtUsername.bottom, margin = 24.dp)
                    start.linkTo(edtUsername.start)
                }
        ) {
            CustomTextField(
                defaultValue = Constants.EMAIL,
                value = email,
                onValueChange = { email = it },
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
                keyboardActions = KeyboardActions(onNext = { passwordFocusRequester.requestFocus() }),
                focusRequester = emailFocusRequester
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(edtPassword) {
                    top.linkTo(edtEmail.bottom, margin = 24.dp)
                    start.linkTo(edtEmail.start)
                }
        ) {
            CustomTextField(
                defaultValue = Constants.PASSWORD,
                value = password,
                onValueChange = { password = it },
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password,
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                focusRequester = passwordFocusRequester
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.13f)
                .constrainAs(btnSignUp) {
                    start.linkTo(parent.start)
                    top.linkTo(edtPassword.bottom)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            GradientButton(
                onClick = {
                    scope.launch {
                        navController.navigate(NavigationDestinations.homeScreen)
                    }
                },
                text = stringResource(id = R.string.sign_up_btn)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(tvAlready) {
                    top.linkTo(btnSignUp.bottom, margin = 24.dp)
                },
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.sign_up_already),
                fontSize = dimensionResource(id = R.dimen.font_size_medium).value.sp,
                color = Color.White,
                modifier = Modifier.clickable {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    RegistrationScreen(rememberNavController())
}