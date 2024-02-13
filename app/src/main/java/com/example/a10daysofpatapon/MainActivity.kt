package com.example.a10daysofpatapon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.a10daysofpatapon.model.Datasource
import com.example.a10daysofpatapon.ui.theme._10DaysOfPataponTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _10DaysOfPataponTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    _10DaysOfPataponApp()
                }
            }
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun _10DaysOfPataponApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = { PataponTopBar() }
    ) {
        LazyColumn(
            contentPadding = it,
            modifier = Modifier
                .paint(
                    painter = painterResource(
                        id = if (isSystemInDarkTheme()) {
                            R.drawable.patapon_history_dark
                        } else {
                            R.drawable.patapon_history_light
                        }
                    ),
                    contentScale = ContentScale.Crop,
                    alpha = 0.3f
                )
        ) {
            itemsIndexed(Datasource.getData()) { index, patapon ->
                PataponCard(
                    modifier = Modifier.padding(
                        vertical = dimensionResource(id = R.dimen.padding_medium),
                        horizontal = dimensionResource(id = R.dimen.padding_small)
                    ),
                    patapon = patapon,
                    dayNumber = index + 1
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PataponTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.Bottom,
            ) {
                Text(
                    text = stringResource(id = R.string.top_bar_title),
                    style = MaterialTheme.typography.displayLarge,
                    color = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.Black
                    },
                    modifier = Modifier
                        .padding(
                            bottom = dimensionResource(id = R.dimen.padding_extra_small),
                            end = dimensionResource(id = R.dimen.padding_extra_small)
                        )
                )
                Image(
                    painter = painterResource(
                        id = if (isSystemInDarkTheme()) {
                            R.drawable.patapon_logo_dark
                        } else {
                            R.drawable.patapon_logo_light
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.height(dimensionResource(id = R.dimen.top_bar_image_size))
                )
            }
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background.copy(alpha = 0.7f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreviewLight() {
    _10DaysOfPataponTheme {
        _10DaysOfPataponApp()
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreviewDark() {
    _10DaysOfPataponTheme(true) {
        _10DaysOfPataponApp()
    }
}