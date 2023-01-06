package eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.components

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
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.AddIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.FavoriteIcon

@Composable
fun FavoriteTrackCard (
    track: Track,
    onItemClick: () -> Unit,
    removeFavoriteTrack: (id: String) -> Unit,
    openDialog: (Track) -> Unit

) {
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
            AddIcon(onClick = { openDialog(track) }, size = DpSize(30.dp, 30.dp))

            FavoriteIcon(onClick = { removeFavoriteTrack(track.id)},
                size = DpSize(30.dp, 30.dp)
            )


        }
    }
}