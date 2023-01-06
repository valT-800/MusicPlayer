package eif.viko.lt.vo.musicplayer.presentation.ui.playlist

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun TrackScreen (
    navController: NavController,
    name: String?,
    preview_url: String?,
    imageUrl: String?,
    artist_name: String?
){
    Scaffold(
        topBar = {
            Row(modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { navController.navigateUp() })
                {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back",)
                }
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFFC9CEF1))
                        ) {
                            append(name.toString())
                        }
                    },
                    modifier = Modifier.padding(10.dp),
                    fontSize = 20.sp
                )
            }

        },
        content = { padding ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                elevation = 10.dp
            ) {

                AsyncImage(
                    modifier = Modifier.fillMaxSize().padding(10.dp),
                    model = imageUrl,
                    contentDescription = name
                )

            }
        }
    )

}
