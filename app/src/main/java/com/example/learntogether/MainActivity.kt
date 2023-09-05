package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    articlePage(
                        titleText = stringResource(R.string.article_title),
                        bodyText1 = stringResource(R.string.article_body_1),
                        bodyText2 = stringResource(R.string.article_body_2)
                    )
                }
            }
        }
    }
}

@Composable
fun articlePage(titleText: String, bodyText1: String, bodyText2: String, modifier: Modifier = Modifier) {

    val image = painterResource(id = R.drawable.bg_compose_background)
    Column (
        modifier = modifier
    ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = titleText,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
            //lineHeight = 100.sp
        )
        articleBodyText(
            bodyText = bodyText1,
            modifier = modifier.padding(horizontal = 16.dp)

        )
        articleBodyText(
            bodyText = bodyText2,
            modifier = modifier.padding(16.dp)

        )

    }
}

@Composable
fun articleBodyText(bodyText: String, modifier: Modifier = Modifier) {
    Text(
        text = bodyText,
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        articlePage(
            titleText = stringResource(R.string.article_title),
            bodyText1 = stringResource(R.string.article_body_1),
            bodyText2 = stringResource(R.string.article_body_2)
        )
    }
}