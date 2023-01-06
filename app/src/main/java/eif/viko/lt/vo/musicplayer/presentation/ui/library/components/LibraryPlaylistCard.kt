package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Playlist
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.DeleteIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.RemoveIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel

@Composable
fun LibraryPlaylistCard (
    playlist: Playlist,
    deletePlaylist: () -> Unit,
    onItemClick: () -> Unit

    ) {
    Card (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth().clickable { onItemClick() },
        elevation = 3.dp

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = playlist.name?: ""
                )
                Text(
                    text = playlist.owner.display_name ?: "",
                    fontWeight = FontWeight.Light,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            RemoveIcon(
                size = DpSize(30.dp, 30.dp),
                onClick = {deletePlaylist()}
            )
        }
    }
}