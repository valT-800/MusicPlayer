package eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel

@Composable
fun FavoriteTracks(
    viewModel: PlaylistViewModel = hiltViewModel(),
    tracksContent: @Composable (tracks: Tracks) -> Unit
) {
    when(val tracksResponse = viewModel.favoriteTracksResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> { tracksContent(tracksResponse.data) }
        is Response.Failure -> print(tracksResponse.e)
        else -> {}
    }
}