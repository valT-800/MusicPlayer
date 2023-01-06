package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.library.LibraryViewModel

@Composable
fun DeletePlaylist (
    viewModel: LibraryViewModel = hiltViewModel()
){
    when( val deletePlaylistResponse = viewModel.deletePlaylistResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> print(deletePlaylistResponse.e)
    }
}