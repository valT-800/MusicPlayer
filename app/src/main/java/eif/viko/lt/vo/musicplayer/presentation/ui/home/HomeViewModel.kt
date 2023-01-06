package eif.viko.lt.vo.musicplayer.presentation.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.PlaylistsResponse
import eif.viko.lt.vo.musicplayer.domain.use_case.database.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    var playlistsResponse by mutableStateOf<PlaylistsResponse>(Response.Loading)
        private set


    init {
        getPlaylists()
    }



    private fun getPlaylists() = viewModelScope.launch{
        useCases.getPlaylists().collect {
            playlistsResponse = it
        }
    }

}