package com.jason.mota.ui.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jason.domain.entities.Resolution
import com.jason.mota.R
import com.jason.mota.component.*
import com.jason.mota.ui.home.model.ResolutionState

@Composable
fun HomeScreen(navController: NavController) {
    val resolutionList = listOf(
        ResolutionState(Resolution("001", "nutrition", "", "", 231, 300), listOf(Color.Blue, Color.Yellow)),
        ResolutionState(Resolution("002", "behavior", "", "", 78, 255), listOf(Color.Green, Color.Blue)),
        ResolutionState(Resolution("003", "fit", "", "", 3072, 2042), listOf(Color.Blue, Color.Magenta)),
        ResolutionState(Resolution("004", "addiction", "", "", 345, 35), listOf(Color.Red, Color.Yellow)),
        ResolutionState(Resolution("005", "productivity", "", "", 987, 215), listOf(Color.Red, Color.White)),
        ResolutionState(Resolution("005", "carrier", "", "", 987, 215), listOf(Color.Red, Color.White)),
        ResolutionState(Resolution("006", "custom", "", "", 1673, 16), listOf(Color.Green, Color.Blue)),
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.black_blue))
    ) {
        val (btnBack, title, resolutions) = createRefs()
        Row(
            modifier = Modifier.constrainAs(btnBack) {
                top.linkTo(parent.top, margin = 24.dp)
                start.linkTo(parent.start, margin = 24.dp)
            }
        ) { BackButton { navController.popBackStack() } }
        Column(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(btnBack.bottom, margin = 24.dp)
                    start.linkTo(btnBack.start, margin = 12.dp)
                }
        ) {
            TextViewScreenTitle(stringResource(id = R.string.home_title))
            Spacer(modifier = Modifier.height(16.dp))
            TextViewRegular(stringResource(id = R.string.home_notice))
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 240.dp)
                .constrainAs(resolutions) {
                    top.linkTo(title.bottom, margin = 24.dp)
                    start.linkTo(parent.start)
                },
        ) {
            items(resolutionList) {
                Surface(
                    modifier = Modifier
                        .padding(36.dp, 12.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .diagonalGradientTint(
                            colors = it.colorState,
                            blendMode = BlendMode.Plus
                        )
                        .clickable {

                        }
                ) {
                    ResolutionItem(resolution = it.data)
                }
            }
        }
    }
}

@Composable
fun ResolutionItem(resolution: Resolution) {
    Column(
        modifier = Modifier
            .height(160.dp)
            .padding(16.dp, 12.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.Top
        ) {
            TextViewTitle(content = stringResource(id = R.string.home_resolution, resolution.name))
        }
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            TextViewRegularMedium(content = stringResource(id = R.string.home_participants, resolution.participants))
            Spacer(modifier = Modifier.height(4.dp))
            TextViewRegularMedium(content = stringResource(id = R.string.home_challenge, resolution.challenges))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen(rememberNavController())
}