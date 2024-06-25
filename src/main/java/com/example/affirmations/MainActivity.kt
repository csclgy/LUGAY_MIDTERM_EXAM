package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.compose.material.icons.filled.ExpandLess
//import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.affirmations.data.Datasource
import com.example.affirmations.data.Dog
import com.example.affirmations.data.dogs
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme
import kotlin.system.exitProcess


//FRANCESCA A. LUGAY
//BSIT 22A3
//MOBILE COMPUTING
//JUNE 26, 2024
//FINAL EXAM

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
            //THIS IS THE SUBMIT BUTTON
            SubmitButton(onClick = {})
        }
    }

    //THIS WILL SHOW UP AFTER CLICKING THE 'CHECK OTHER CELEBRITIES' BUTTON
    fun onCreatee(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    WoofApp()
                }
            }
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
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 2.dp)
                .padding(horizontal = 120.dp)
        )

    }
    Column {
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
            modifier = Modifier
                .padding(top = 180.dp)
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
            .padding(top = 470.dp)
            .padding(horizontal = 10.dp)
    )
}


//THE WHOLE INPUT FORM FOR USER
//input field with submit button
@Composable
fun inputuser(){
    Column {
        Text(
            text = "WHAT'S YOUR FAVORITE SONG FROM THE NEW ALBUM?",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 600.dp)
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
//NOTE: AFTER CLICKING THE BUTTON DIRECTS YOU TO THE THANK YOU MESSAGE!
@Composable
fun SubmitButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 750.dp)
            .padding(horizontal = 20.dp)
            .size(200.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(onClick = { result = 1 }) {
            Text("Submit")
        }
    }

    Column{
        if (result == 1){
            thankyou()
            Row {
                SubmitButtonn(onClick = {})
            }
        }
    }
}

@Composable
fun SubmitButtonn(onClick: () -> Unit, modifier: Modifier = Modifier) {
    var resultt by remember { mutableStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth()
    ){
        Button(onClick = { resultt = 2 }) {
            Text("Cancel")
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

@Composable
fun WoofApp() {
    Scaffold(
        topBar = {
            WoofTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(dogs) {
                DogItem(
                    dog = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }

}
@Composable
fun DogItem(
    dog: Dog,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                DogIcon(dog.imageResourceId)
                DogInformation(dog.name, dog.age)
                Spacer(Modifier.weight(1f))
//                DogItemButton(
//                    expanded = expanded,
//                    onClick = { expanded = !expanded },
//                )
            }
            if (expanded) {
                DogHobby(
                    dog.hobbies, modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

//@Composable
//private fun DogItemButton(
//    expanded: Boolean,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    IconButton(
//        onClick = onClick,
//        modifier = modifier
//    ) {
//        Icon(
//            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
//            contentDescription = stringResource(R.string.expand_button_content_description),
//            tint = MaterialTheme.colorScheme.secondary
//        )
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WoofTopAppBar(modifier: Modifier = Modifier) {
    var resulttt by remember { mutableStateOf(0) }
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_namee),
                    style = MaterialTheme.typography.displayLarge
                )

                //THIS IS THE EXIT BUTTON, IF EVER USER IS DONE LOOKING AT THE LISTS
                Button(onClick = {resulttt = 4}) {
                    Text("X")
                }
                if (resulttt == 4){
                    exitProcess(1)
                }
            }
        },
        modifier = modifier
    )
}
@Composable
fun DogIcon(
    @DrawableRes dogIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(dogIcon),

        contentDescription = null
    )
}
@Composable
fun DogInformation(
    @StringRes dogName: Int,
    dogAge: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(dogName),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.years_old, dogAge),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DogHobby(
    @StringRes dogHobby: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(dogHobby),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

//THANK YOU MESSAGE AFTER CLICKING THE SUBMIT BUTTON
@Composable
fun thankyou() {
    var resultt by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(255, 255, 255),

                ),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),


            ) {
            if (resultt == 2){
                exitProcess(1)
            }
            if (resultt == 3){
                AffirmationsTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        WoofApp()
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.check_symbol),
                    contentDescription = null,
                    modifier = Modifier
                        .width(500.dp)
                        .height(500.dp)
                )
                Text(
                    text ="Form Submitted Successfully",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 10.dp)
                )
                Text(
                    text = "Thank you for sharing your opinion to us!",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 40.dp)
                )

                //NEW
                //EXIT BUTTON EXITS OUT USER FROM THE APP
                //CHECK OTHER CELEBRITIES WILL LEAD USER TO ANOTHER SCREEN
                Button(onClick = {resultt = 3}) {
                    Text("Check Other Celebrities")

                }
                Button(onClick = { resultt = 2}) {
                    Text("Exit")

                }

            }

        }

        }


    }


//PREVIEW
@Preview
@Composable
private fun AffirmationCardPreview() {
    AffirmationCard(Affirmation(R.string.affirmation1, R.drawable.ttpd_img1))
}


