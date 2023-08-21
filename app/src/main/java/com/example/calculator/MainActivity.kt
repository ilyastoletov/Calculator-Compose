package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

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
    Column(modifier = Modifier.fillMaxSize()) {
        OutputBlock()
        DigitsBlock()
    }
}

@Composable
fun OutputBlock() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.4f)
        .background(color = Color.White),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(text = "Тут будет вывод", style = TextStyle(color = Color.Black, fontSize = TextUnit(16.0f, TextUnitType.Sp)))
    }
}

@Composable
fun DigitsBlock() {

    val calculatorButtons = listOf("1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "0")

    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
            .background(Color.White),
        userScrollEnabled = false,
        rows = GridCells.Fixed(4),
        contentPadding = PaddingValues(5.dp)) {
        items(calculatorButtons.size) {i ->
            Card(
                shape = RoundedCornerShape(15.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan, contentColor = Color.Black),
            ) {
                Text(text = calculatorButtons[i])
            }
        }
    }
}

  /*  Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.6f)
        .background(Color.Cyan)) {

        LazyHorizontalGrid(rows = GridCells.Fixed(4), contentPadding = PaddingValues(5.dp)) {items(calculatorButtons.size) { item -> }
        }

    }*/