package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.Playlists
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.library.LibraryViewModel

@Composable
fun LibraryPlaylists(
    viewModel: LibraryViewModel = hiltViewModel(),
    playlistsContent: @Composable (playlists: Playlists) -> Unit
) {
    when(val playlistsResponse = viewModel.myPlaylistsResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> playlistsContent(playlistsResponse.data)
        is Response.Failure -> print(playlistsResponse.e)
    }
}