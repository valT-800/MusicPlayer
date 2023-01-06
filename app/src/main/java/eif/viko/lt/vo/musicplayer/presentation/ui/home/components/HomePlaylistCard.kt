package eif.viko.lt.vo.musicplayer.presentation.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import eif.viko.lt.vo.musicplayer.domain.model.Playlist

@Composable
fun HomePlaylistCard (
    playlist: Playlist,
    onItemClick: () -> Unit

) {

    Card (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable{onItemClick()},
        elevation = 3.dp

    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier.width(100.dp).padding(8.dp),
                model = playlist.images[0].url,
                contentDescription = playlist.name
            )
            Column {
                Text(

                    text = playlist.name?: "",

                )
                Text(

                    text = playlist.owner.display_name ?: "",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
        }
    }
}