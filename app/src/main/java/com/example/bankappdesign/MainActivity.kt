package com.example.bankappdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappdesign.ui.theme.BankAppDesignTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                UpperPart()
                CardUI()
            }
        }
    }
}


@Composable
fun UpperPart() {
    Row(modifier = Modifier.padding(top = 5.dp)) {
        Text(
            text = "Welcome back, Aboltus!",
            modifier = Modifier
                .absolutePadding(20.dp, 30.dp)
                .height(25.dp),
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.metropolissemibold))
        )
        Image(
            painter = painterResource(id = R.drawable.img2),
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .padding(start = 35.dp, top = 0.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun CardUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
//            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        ElevatedCard(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD9D9D9)),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            modifier = Modifier
                .padding(10.dp)
                .height(230.dp)
                .fillMaxSize()

        ) {

//            Image(
//                painter = painterResource(id = R.drawable.img),
//                contentDescription = "",
//                modifier = Modifier
//                    .rotate(90F)
//                    .fillMaxSize()
//            )
            Row {
                Column(verticalArrangement = Arrangement.Bottom) {
                    Text(
                        text = "Debit",
                        fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp)

                    )
                    Spacer(modifier = Modifier.height(145.dp))
                    Text(
                        fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                        text = "BALANCE",
                        color = Color.Black,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                    )
                    Text(
                        fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                        text = "$ 5,227",
                        color = Color.Black,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(top = 5.dp, start = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.width(200.dp))
                Button(
                    onClick = {},

                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(Color(0xD9D9D9))
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "...",
                            color = Color.Black,
                            modifier = Modifier
                                .padding(bottom = 20.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_dashboard_24),
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }
                }

            }

        }
        Card(
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
                .height(50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFD9D9D9) // Устанавливаем белый цвет для карточки
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Image(
                        modifier = Modifier.padding(start = 5.dp),
                        painter = painterResource(id = R.drawable.visa),
                        contentDescription = null
                    )
                    Text(
                        text = "* 1432",
                        fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )


                }
                Text(
                    text = "$ 13,889",
                    fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                    fontSize = 15.sp
                )
            }

        }
        Text(
            text = "Budget",
            fontFamily = FontFamily(Font(R.font.metropolissemibold)),
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)


        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth(50F)
            ) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD9D9D9) // Устанавливаем белый цвет для карточки
                    ),
                    modifier = Modifier.size(165.dp)

                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        CircularProgressBar(precentage = 0.52f, number = 100)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Travel",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                            )
                            Text(
                                text = "52%",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Text(
                            text = "$ 52 left",
                            fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD9D9D9) // Устанавливаем белый цвет для карточки
                    ),
                    modifier = Modifier.size(165.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        CircularProgressBar(precentage = 0.69f, number = 100, color = Color.Blue)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Groceries",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                            )
                            Text(
                                text = "69%",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Text(
                            text = "$ 52 left",
                            fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(50F)
                    .padding(top = 5.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD9D9D9) // Устанавливаем белый цвет для карточки
                    ),
                    modifier = Modifier.size(165.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        CircularProgressBar(precentage = 0.19f, number = 100, color = Color.Green)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Electronics",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                            )
                            Text(
                                text = "19%",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Text(
                            text = "$ 52 left",
                            fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFD9D9D9) // Устанавливаем белый цвет для карточки
                    ),
                    modifier = Modifier.size(165.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),

                        ) {
                        CircularProgressBar(precentage = 0.11f, number = 100, color = Color.Yellow)
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp)
                        ) {
                            Text(
                                text = "Flowers",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                            )
                            Text(
                                text = "11%",
                                fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                                modifier = Modifier.padding(end = 10.dp)
                            )
                        }
                        Text(
                            text = "$ 52 left",
                            fontFamily = FontFamily(Font(R.font.metropolissemibold)),
                            modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun CircularProgressBar(
    precentage: Float,
    number: Int,
    fontSize: TextUnit = 15.sp,
    radius: Dp = 35.dp,
    color: Color = Color.Red,
    animDiration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    var currentValue = animateFloatAsState(
        targetValue = if (animationPlayed) precentage else 0F,
        animationSpec = tween(
            durationMillis = animDiration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(radius * 2F)
            .padding(start = 10.dp, top = 10.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(radius * 2f)
                .padding()
        ) {

            val canvasSize = size.width
            val strokeWidth = canvasSize * 0.1f // 10% of the canvas size
            val centerX = size.width / 2f
            val centerY = size.height / 2f
            val radius = (canvasSize - strokeWidth) / 2f

//            drawRoundRect(
//                color = color,
//                size = Size(canvasSize,canvasSize),
//                cornerRadius = CornerRadius(8f,8f)
//            )

            drawArc(
                color = color,
                startAngle = -90F,
                sweepAngle = currentValue.value * 360,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentValue.value * number).toInt().toString(),
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.metropolissemibold))
        )
    }
}