package com.example.dados

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jogo_de_dados.R
import com.example.jogo_de_dados.ui.theme.Jogo_de_dadosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jogo_de_dadosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Inicio(
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun Inicio(name: String, modifier: Modifier = Modifier) {


    var sorteio by remember {
        mutableStateOf(1)}

    var img_sorteada = when(sorteio){

        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6

    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Jogue os Dados",
            fontSize = 45.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Image(
            painter = painterResource(id = img_sorteada),
            contentDescription = "Dados",
            modifier = Modifier
                .width(1100.dp)
                .padding(30.dp)
        )

     Button(
            onClick = { sorteio = (1..6).random() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text(text = "Jogar",
                fontSize = 25.sp
            )

        }
    }
}


@Preview (showBackground = true)
@Composable
    fun GreetingPreviewo() {
    Jogo_de_dadosTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Inicio(
                name = "Android"
            )
        }}}