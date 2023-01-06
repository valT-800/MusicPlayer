package eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel

@Composable
fun AddTrackToPlaylist (
    viewModel: PlaylistViewModel = hiltViewModel()

){
    when( val response = viewModel.addTrackResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> print(response.e)
    }
}