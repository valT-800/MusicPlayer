package eif.viko.lt.vo.musicplayer.presentation.ui.home.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.Playlists
import eif.viko.lt.vo.musicplayer.presentation.ui.home.HomeViewModel

@Composable
fun HomePlaylists(
    viewModel: HomeViewModel = hiltViewModel(),
    playlistsContent: @Composable (playlists: Playlists) -> Unit
) {
    when(val playlistsResponse = viewModel.playlistsResponse){
        is Response.Success -> playlistsContent(playlistsResponse.data)
        is Response.Failure -> print(playlistsResponse.e)
        else -> {}
    }
}