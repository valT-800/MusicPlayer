package eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.*

@Composable
fun HomeTrackCard (
    track: Track,
    onItemClick: () -> Unit,
    removeFavoriteTrack: () -> Unit,
    addFavoriteTrack: () -> Unit,
    openDialog: () -> Unit

) {
    var trackAdded by remember{mutableStateOf(false)}
    Card (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 3.dp

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp)
                .clickable {
                    onItemClick()
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = track.name?: ""
                )
                Text(
                    text = track.artists[0].name ?: "",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )

            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            AddIcon(onClick = { openDialog() }, size = DpSize(30.dp, 30.dp))

            if(trackAdded) {
                FavoriteIcon(onClick = {
                    removeFavoriteTrack()
                    trackAdded = false},
                    size = DpSize(30.dp, 30.dp))
            }
            else{
                FavoriteIconBorder(onClick = {
                    addFavoriteTrack()
                    trackAdded = true },
                    size = DpSize(30.dp, 30.dp))

            }
        }
    }
}