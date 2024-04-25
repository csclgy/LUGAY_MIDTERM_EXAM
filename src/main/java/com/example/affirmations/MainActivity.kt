package com.example.affirmations

import android.R.attr.button
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme


//FRANCESCA A. LUGAY
//BSIT 22A3
//MOBILE COMPUTING
//APRIL 25, 2024
//MIDTERM EXAM

var textInput = mutableStateOf("")

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    AffirmationsApp()
                    inputuser()
                }
            }
            SubmitButton(onClick = {})
        }
    }
}

//HEADER AND CONTENTS
@Composable
fun AffirmationsApp() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ttpd_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "THE TORTURED POETS DEPARTMENT",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 42.dp)
        )
        Text(
            text = "All’s fair in love and poetry.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 5.dp)
                .padding(horizontal = 90.dp)
        )

    }
    Column {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
            modifier = Modifier
                .padding(top = 170.dp)
                .padding(bottom = 390.dp)
                .fillMaxSize()
        )
    }
    Text(
        text = "The Tortured Poets Department. " +
                "An anthology of new works that reflect events, " +
                "opinions and sentiments from a fleeting and fatalistic moment " +
                "in time - one that was both sensational and sorrowful in equal measure. " +
                "This writer is of the firm belief that our tears become holy in the form of ink on a page. " +
                "Once we have spoken our saddest story, we can be free of it.",
        fontSize = 12.sp,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(top = 460.dp)
            .padding(horizontal = 10.dp)
    )
}


//THE WHOLE INPUT FORM FOR USER
@Composable
fun inputuser(){
    Column {
        Text(
            text = "WHAT'S YOUR FAVORITE SONG FROM THE NEW ALBUM?",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 620.dp)
                .padding(horizontal = 10.dp)
        )
        EditTextField(
            modifier = Modifier
                .padding(top = 10.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth())

        EditTextFieldd(modifier = Modifier
            .padding(top = 5.dp)
            .padding(horizontal = 20.dp)
            .fillMaxWidth())

    }
}

//FIRST TEXT FIELD
@Composable
fun EditTextField(modifier: Modifier = Modifier) {
    var textInput by remember { mutableStateOf("") }

    TextField(
        value = textInput,
        onValueChange = {textInput = it},
        singleLine = true,
        label = { Text(stringResource(R.string.label)) },
        modifier = modifier
    )
}

//SECOND TEXT FIELD
@Composable
fun EditTextFieldd(modifier: Modifier = Modifier) {
    var textInputt by remember { mutableStateOf("") }

    TextField(
        value = textInputt,
        onValueChange = {textInputt = it},
        singleLine = true,
        label = { Text(stringResource(R.string.label2)) },
        modifier = modifier
    )
}

//SUBMIT BUTTON
//NOTE: DOES NOT HAVE ACTION
@Composable
fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 750.dp)
            .padding(horizontal = 20.dp)
            .size(200.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = { onClick() }) {
            Text("Submit")
        }
    }
}

//LIST OF SONGS IN THE ALBUMS
@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }
}

//DESIGN OF THE LIST
@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


//PREVIEW
@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.ttpd_img1))
}
