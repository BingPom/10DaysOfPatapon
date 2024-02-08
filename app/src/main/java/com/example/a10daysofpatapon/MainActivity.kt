package com.example.a10daysofpatapon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose._10DaysOfPataponTheme

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

@Composable
fun _10DaysOfPataponApp(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    _10DaysOfPataponTheme {
        _10DaysOfPataponApp()
    }
}