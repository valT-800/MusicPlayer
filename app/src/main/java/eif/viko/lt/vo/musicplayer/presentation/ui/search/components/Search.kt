package eif.viko.lt.vo.musicplayer.presentation.ui.search.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.ProgressBar
import eif.viko.lt.vo.musicplayer.presentation.ui.search.SearchViewModel

@Composable
fun Search(
    viewModel: SearchViewModel = hiltViewModel(),
    searchContent: @Composable (tracks: Tracks) -> Unit
){


    when(val tracksResponse = viewModel.allTracksResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> searchContent(tracksResponse.data)
        is Response.Failure -> print(tracksResponse.e)
        else -> {}
    }

}