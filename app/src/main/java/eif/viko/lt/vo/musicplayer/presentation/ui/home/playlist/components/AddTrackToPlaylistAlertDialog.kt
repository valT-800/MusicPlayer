package eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.domain.model.Playlist
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.RemoveIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.library.LibraryViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.library.components.LibraryContent
import eif.viko.lt.vo.musicplayer.presentation.ui.library.components.LibraryPlaylistCard
import eif.viko.lt.vo.musicplayer.presentation.ui.library.components.LibraryPlaylists
import kotlinx.coroutines.selects.whileSelect


@Composable
fun AddTrackToPlaylistAlertDialog (
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addTrackToPlaylist: (id: String, track: Track) -> Unit,
    track: Track,
    viewModel: LibraryViewModel = hiltViewModel()
){
    var playlist_id by remember { mutableStateOf("") }
    if(openDialog){
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(id = R.string.choose_playlist))
            },
            text = {
                LibraryPlaylists(
                    playlistsContent = { playlists ->
                        LazyColumn(

                        ) {
                            items(items = playlists,)
                            { playlist ->
                                Card (
                                    shape = MaterialTheme.shapes.small,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth()
                                        .clickable { playlist_id = playlist.id },
                                    elevation = 3.dp

                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(12.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(text = playlist.name?: "")
                                    }
                                }
                            }
                        }
                    }
                )
                /*LaunchedEffect(Unit) {
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }*/

            },
            confirmButton = {
                TextButton(
                    onClick = {
                        addTrackToPlaylist(playlist_id, track)
                        closeDialog()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.add)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = stringResource(id = R.string.close)
                    )
                }
            }
        )
    }
}