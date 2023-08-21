package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                CalculatorScreen()
            }
        }
    }
}

@Composable
fun CalculatorScreen() {

    var inputText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        OutputBlock(outputText = inputText)
        DigitsBlock(onDigitClicked = { input -> inputText += input })
    }
}

@Composable
fun Header() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.1f)) {
        Text(
            text = "Calculator",
            textAlign = TextAlign.Start,
            style = TextStyle(color = Color.Black),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp, top = 3.dp)
        )
    }
}

@Composable
fun OutputBlock(outputText: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.3f)
        .background(color = Color.White),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = outputText,
            style = TextStyle(color = Color.Black),
            fontSize = 35.sp, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(end = 5.dp)
        )
    }
}

@Composable
fun DigitsBlock(onDigitClicked: (String) -> Unit) {

    val calculatorButtons = listOf("1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "0")

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        userScrollEnabled = false,
        columns = GridCells.Fixed(4)
    ) {
        items(calculatorButtons) {button ->
            CalculatorItem(buttonText = button, onDigitClicked = onDigitClicked)
        }
    }

}

@Composable
fun CalculatorItem(buttonText: String, onDigitClicked: (String) -> Unit) {
    Box(
        modifier = Modifier
            .width(30.dp)
            .height(150.dp)
            .padding(2.dp)
            .background(lightGreen, RoundedCornerShape(10.dp))
            .clickable { onDigitClicked(buttonText) },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = buttonText,
            style = TextStyle(color = Color.Black),
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}/*@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        OutputBlock()
        DigitsBlock()
    }
}*/