package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun ImageWithText(imageResource: Int, textResource: Int, information:String,onImageCilck: () -> Unit, modifier: Modifier = Modifier) {
    Box {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = onImageCilck,
                shape = RoundedCornerShape(35.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = information,
                    modifier = Modifier
                        .size(250.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(35.dp))
                        .padding(15.dp)
                )
            }
            Text(
                text = stringResource(id = textResource),
                fontSize = 18.sp,
                modifier = modifier.padding(16.dp)
            )
        }
    }

}

@Composable
fun LemonadeBuild(modifier: Modifier = Modifier) {
    var stepCounter:Int by remember { mutableStateOf(1) }
    var squeezeCount: Int by remember { mutableStateOf(1) }


    when(stepCounter) {
        1 -> ImageWithText(
            imageResource = R.drawable.lemon_tree,
            textResource = R.string.lemon_tree,
            information = "Lemon Tree",
            onImageCilck = { stepCounter = 2
                squeezeCount = (2..4).random()
            })
        2 -> ImageWithText(
            imageResource = R.drawable.lemon_squeeze,
            textResource = R.string.squeeze,
            information = "Lemon Squeeze",
            onImageCilck = { squeezeCount--
                if(squeezeCount == 0) {
                    stepCounter = 3
                }
            })
        3 -> ImageWithText(
            imageResource = R.drawable.lemon_drink,
            textResource = R.string.drink,
            information = "Drink",
            onImageCilck = { stepCounter = 4 })
        4 -> ImageWithText(
            imageResource = R.drawable.lemon_restart,
            textResource = R.string.empty,
            information = "Drink",
            onImageCilck = { stepCounter = 1 })
    }
}

@Composable
fun MainHeader(modifier: Modifier = Modifier) {
    Text(
        text = "Lemonade",

        modifier = modifier.fillMaxWidth().padding(20.dp).background(Color.Yellow)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp() {
    MainHeader()
    LemonadeBuild()
}

