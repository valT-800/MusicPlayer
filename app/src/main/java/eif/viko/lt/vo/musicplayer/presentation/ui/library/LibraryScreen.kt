package eif.viko.lt.vo.musicplayer.presentation.ui.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.AddIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.library.components.*

@Composable
fun LibraryScreen (
    navController: NavController,
    viewModel: LibraryViewModel = hiltViewModel(),

){
    Scaffold (
        content = { padding ->
            LibraryPlaylists(
                playlistsContent = { playlists ->
                    LibraryContent(
                        navController = navController,
                        padding = padding,
                        playlists = playlists,
                        deletePlaylist = { id -> viewModel.deletePlaylist(id) },
                        openDialog = {viewModel.openDialog()})
                }
            )


            AddPlaylistAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialog() },
                addPlaylist =  { name -> viewModel.addPlaylist(name) }
            )

        },
        floatingActionButton = {
             AddPlaylistFloatingActionButton(
                openDialog = {viewModel.openDialog()}
            )
        }
    )
    AddPlaylist()
    DeletePlaylist()
}