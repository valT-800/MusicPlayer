package eif.viko.lt.vo.musicplayer.presentation.ui.playlist

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
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
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.exoplayer2.ExoPlayer
import eif.viko.lt.vo.musicplayer.domain.model.Artist

@Composable
fun SongScreen (
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),
    name: String?,
    preview_url: String?,
    imageUrl: String?,
    artist_name: String?
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(Modifier.fillMaxWidth()){
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
                Text(text = "Back", modifier = Modifier.padding(start = 1.dp, top=12.dp))
            }
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ) {
                        append(name.toString())
                    }
                },
                modifier = Modifier.padding(10.dp)
            )
            AsyncImage(
                modifier = Modifier.width(200.dp),
                model = imageUrl,
                contentDescription = name
            )
            Text(text = artist_name.toString())
        }
    }
}
