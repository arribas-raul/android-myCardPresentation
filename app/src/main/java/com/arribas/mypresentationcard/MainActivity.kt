package com.arribas.mypresentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arribas.mypresentationcard.ui.theme.MyPresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF002435)
                ) {
                    printCard()
                }
            }
        }
    }
}

@Composable
fun printCard(){
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF002435))
            .padding(bottom = 40.dp)) {
        printBody(modifier = Modifier.weight(0.8f))
        printFooter(modifier = Modifier.weight(0.2f))
    }
}

@Composable
fun printBody(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
               .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.width(150.dp)
        )

        Text(
            text = "Raúl Arribas",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Full Stack Developer",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFF008718),
            modifier = Modifier.padding(top = 10.dp)
        )
    }

}

@Composable
fun printFooter(modifier: Modifier = Modifier){
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFF002435))) {

        printInfo(painterResource(R.drawable.ic_phone_foreground), "+34 636 96 01 74")
        printInfo(painterResource(R.drawable.ic_share_foreground), "linkedin.com/in/raúl-arribas-a7570a64")
        printInfo(painterResource(R.drawable.ic_envelope_foreground), "arribas.raul@gmail.com")
    }
}

@Composable
fun printLine(modifier: Modifier = Modifier){
    Divider(color = Color.White, thickness = 0.5.dp)
}

@Composable
fun printInfo(painter: Painter, msg: String, modifier: Modifier = Modifier){
    printLine()
    Row(
        modifier = modifier
            .padding(start = 45.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.width(45.dp)
        )

        Text(
            text = msg,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 5.dp)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyPresentationCardTheme {
        printCard()
    }
}