package eif.viko.lt.vo.musicplayer.presentation.ui.player.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.player.PlayerViewModel

@Composable
fun Play (
    viewModel: PlayerViewModel = hiltViewModel()
){

    when (val response = viewModel.playResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> viewModel.playerState = response.data
        is Response.Failure -> print(response.e)
        else -> {}

    }
}
