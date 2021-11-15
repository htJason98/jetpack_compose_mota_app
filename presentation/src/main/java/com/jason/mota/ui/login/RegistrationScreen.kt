package com.jason.mota.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.jason.mota.R
import com.jason.mota.common.Constants
import com.jason.mota.ui.home.GradientTextView

@Composable
fun RegistrationScreen(navController: NavController?) {
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
                    navController?.popBackStack()
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
            Button(
                onClick = {

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
                GradientTextView(stringResource(id = R.string.sign_up_btn))
            }
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

@Preview(showBackground = true)
@Composable
fun Preview() {
    RegistrationScreen(null)
}