package com.tcreatesllc.tvapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.AssistChip
import androidx.tv.material3.AssistChipDefaults
import androidx.tv.material3.Border
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.InputChip
import androidx.tv.material3.InputChipDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Tab
import androidx.tv.material3.TabRow
import androidx.tv.material3.TabRowDefaults
import com.tcreatesllc.tvapp.ui.theme.TvAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TvAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    shape = RectangleShape
                ) {
                    var selectedTabIndex by remember { mutableStateOf(0) }
                    //  Greeting("Android")
                    val tabs = listOf("HOME", "MODELS", "PIECES", "SERVICE", "TOUR", "CONTACT")
                    //leftTabRow(leftSelectedTabIndex, tabs)
                    topRow(selectedTabIndexArg = selectedTabIndex, tabs = tabs)


                }
            }
        }
    }
}

val tvvAppFontFamily = FontFamily(
    Font(R.font.oswald_light, FontWeight.Light),
    Font(R.font.oswald_regular, FontWeight.Normal),
    Font(R.font.oswald_medium, FontWeight.Medium),
    Font(R.font.oswald_bold, FontWeight.Bold)
)


@Composable
fun topRow(selectedTabIndexArg: Int, tabs: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        topLeftChip()
        tabsAndLogo(selectedTabIndexArg, tabs)
        topRightChip()

    }
}

@Composable
fun tabsAndLogo(selectedTabIndexArg: Int, tabs: List<String>) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(10.dp)
            .wrapContentSize()
    ) {
        topTab(selectedTabIndexArg, tabs)
        Image(
            painter = painterResource(id = R.drawable.lamborghini_logo_dup),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.TopCenter)
        )
    }
}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun topRightChip() {
    AssistChip(
        onClick = {},
        border = AssistChipDefaults.border(
            border = Border(
                border = BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.surfaceVariant
                )
            )
        ),
        colors = AssistChipDefaults.colors(containerColor = Color.Transparent),
        shape = AssistChipDefaults.shape(shape = RoundedCornerShape(45)),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.rounded_arrow_forward_ios_24),
                contentDescription = "Localized description",
                tint = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier.padding(end = 10.dp)
            )
        },
        modifier = Modifier.wrapContentSize()
    ) {
        Box(

            modifier = Modifier
                .background(Color.Transparent)
                .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
                .wrapContentWidth()
        ) {

            Text(
                fontFamily = tvvAppFontFamily,
                fontWeight = FontWeight.Light,
                text = "Shopping cart",

                fontSize = 12.sp,
                //color = Color.White,
                modifier = Modifier
                    .padding(end = 55.dp)
                    .align(Alignment.CenterStart)
            )
            Text(
                fontFamily = tvvAppFontFamily,
                fontWeight = FontWeight.Bold,
                text = "3 items",
                color = MaterialTheme.colorScheme.surfaceTint,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            )


        }
    }


}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun topLeftChip() {
    InputChip(
        onClick = { /* Handle input logic here */ },
        selected = false,
        border = InputChipDefaults.border(
            hasAvatar = false,
            border = Border(
                border = BorderStroke(
                    1.dp,
                    Color.White
                )
            )
        ),
        colors = InputChipDefaults.colors(containerColor = Color.Transparent),
        shape = InputChipDefaults.shape(shape = RoundedCornerShape(45), hasAvatar = false),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Localized description",
                modifier = Modifier.padding(end = 10.dp)
            )
        },
        modifier = Modifier.wrapContentSize()
    ) {
        Box(

            modifier = Modifier
                .background(Color.Transparent)
                .padding(start = 10.dp, end = 5.dp, top = 5.dp, bottom = 5.dp)
                .wrapContentWidth()
        ) {

            Text(
                fontFamily = tvvAppFontFamily,
                fontWeight = FontWeight.Light,
                text = "Search your car",

                fontSize = 12.sp,
                //color = Color.White,
                modifier = Modifier
                    .padding(end = 35.dp)
                    .align(Alignment.CenterStart)
            )


        }
    }


}

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun topTab(selectedTabIndexArg: Int, tabs: List<String>) {
    var selectedTabIndex = selectedTabIndexArg

    // var  by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        indicator = { tabPositions, doesTabRowHaveFocus ->
            // FocusedTab's indicator
            TabRowDefaults.PillIndicator(
                currentTabPosition = tabPositions[selectedTabIndex],
                activeColor = Color.Transparent,
                inactiveColor = Color.Transparent,
                doesTabRowHaveFocus = doesTabRowHaveFocus,
            )
        },
        separator = { Spacer(modifier = Modifier.width(12.dp)) },
        modifier = Modifier.focusRestorer()
    ) {
        tabs.forEachIndexed { index, tab ->
            key(index) {
                Tab(
                    selected = index == selectedTabIndex,
                    onFocus = { selectedTabIndex = index },
                    modifier = Modifier.padding(
                        start = if (index == 3) {
                            60.dp
                        } else {
                            0.dp
                        }
                    )
                ) {
                    Text(
                        text = tab,
                        fontFamily = tvvAppFontFamily,
                        fontWeight = if (index == selectedTabIndex) {
                            FontWeight.Bold
                        } else {
                            FontWeight.Light
                        },
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        color = if (index == selectedTabIndex) {
                            MaterialTheme.colorScheme.surfaceTint
                        } else {
                            Color.White
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun wheelCardCaption(caption1: String, caption2: String, caption1Color: Color) {
    Column(
        modifier = Modifier.padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = caption1Color,
            text = caption1,
            fontWeight = FontWeight.Light,
            fontFamily = tvvAppFontFamily,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Text(
            color = Color.LightGray,
            fontFamily = tvvAppFontFamily,
            text = caption2,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun wheelCard(drawableInt: Int,
              caption1: String,
              caption2: String,
              caption3: String,
              caption4: String) {
    Card(
        modifier = Modifier.wrapContentSize(),
        onClick = { },
        colors = CardDefaults.colors(containerColor = Color(0xFF28384F))
    ) {
        Box(modifier = Modifier.padding(end = 15.dp, start = 25.dp, top = 15.dp, bottom = 10.dp)) {
            StrokedCircleIcon(mods = Modifier.align(Alignment.TopEnd))
            wheelCardColumn(
                drawableInt = drawableInt,
                caption1 = caption1,
                caption2 = caption2,
                caption3 = caption3,
                caption4 = caption4
            )
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun wheelCardColumn(
    drawableInt: Int,
    caption1: String,
    caption2: String,
    caption3: String,
    caption4: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Image(
            painter = painterResource(id = drawableInt),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
        wheelCardCaption(
            caption1 = caption1,
            caption2 = caption2,
            caption1Color = Color.White
        )
        wheelCardCaption(
            caption1 = caption3,
            caption2 = caption4,
            caption1Color = MaterialTheme.colorScheme.surfaceTint
        )

    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun StrokedCircleIcon(mods: Modifier) {
    val stroke = Stroke(
        width = 3f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(2.5f, 2.5f), 0f)
    )
    Box(
        mods
            .drawBehind {
                drawCircle(
                    color = Color(0xFFFFEAB8),
                    style = stroke
                )
            }
            .wrapContentSize()
            .clip(CircleShape)
            .background(color = Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.rounded_arrow_forward_ios_24),
            contentDescription = "Localized description",
            tint = MaterialTheme.colorScheme.surfaceTint,
            modifier = Modifier
                .padding(2.5.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.lambo),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ComponentPreview() {
    TvAppTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            shape = RectangleShape
        ) {
            //StrokedCircleIcon()
    wheelCard(drawableInt = R.drawable.wheel_left,
        caption1 = "POTENZA RE-71R",
        caption2 = "Ultimate performance",
        caption3 = "$1251.00",
        caption4 = "Price varies by size")
        }
    }
}