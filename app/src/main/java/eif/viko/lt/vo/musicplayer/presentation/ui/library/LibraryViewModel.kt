package eif.viko.lt.vo.musicplayer.presentation.ui.library

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.AddPlaylistResponse
import eif.viko.lt.vo.musicplayer.domain.repository.DeletePlaylistResponse
import eif.viko.lt.vo.musicplayer.domain.repository.PlaylistsResponse
import eif.viko.lt.vo.musicplayer.domain.use_case.database.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    var myPlaylistsResponse by mutableStateOf<PlaylistsResponse>(Response.Loading)
        private set
    var addPlaylistResponse by mutableStateOf<AddPlaylistResponse>(Response.Success(false))
        private set
    var deletePlaylistResponse by mutableStateOf<DeletePlaylistResponse>(Response.Success(false))
        private set
    var openDialog by mutableStateOf(false)
        private set


    init {

        getMyPlaylists()
    }


    private fun getMyPlaylists() = viewModelScope.launch{
        useCases.getMyPlaylists().collect {
            myPlaylistsResponse = it
        }
    }
    fun addPlaylist(name: String) = viewModelScope.launch {
        addPlaylistResponse = Response.Loading
        addPlaylistResponse = useCases.addPlaylist(name)
        getMyPlaylists()
    }

    fun deletePlaylist(id: String) = viewModelScope.launch {
        deletePlaylistResponse = Response.Loading
        deletePlaylistResponse = useCases.deletePlaylist(id)
        getMyPlaylists()
    }

    fun openDialog() {
        openDialog = true
    }
    fun closeDialog() {
        openDialog = false
    }

}