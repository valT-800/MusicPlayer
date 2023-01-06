package eif.viko.lt.vo.musicplayer.presentation.ui.playlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.*
import eif.viko.lt.vo.musicplayer.domain.use_case.database.UseCases
import eif.viko.lt.vo.musicplayer.domain.util.Constants.EMPTY_TRACK
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val useCases: UseCases,
):ViewModel() {

    var myTracksResponse by mutableStateOf<TracksResponse>(Response.Loading)
        private set
    var tracksResponse by mutableStateOf<TracksResponse>(Response.Loading)
        private set
    var favoriteTracksResponse by mutableStateOf<TracksResponse>(Response.Loading)
        private set
    var addTrackResponse by mutableStateOf<AddTrackResponse>(Response.Success(false))
        private set
    var removeTrackResponse by mutableStateOf<DeleteTrackResponse>(Response.Success(false))
        private set
    var addFavoriteTrackResponse by mutableStateOf<ActionResponse>(Response.Success(false))
        private set
    var removeFavoriteTrackResponse by mutableStateOf<ActionResponse>(Response.Success(false))
        private set
    var trackToPlaylist by mutableStateOf(EMPTY_TRACK)
        private set
    var openDialog by mutableStateOf(false)
        private set

    init {
        getFavoriteTracks()
    }
    fun getMyPlaylistTracks(id: String) = viewModelScope.launch{
        useCases.getMyPlaylistTracks(id).collect {
            myTracksResponse = it
        }
    }
    fun getPlaylistTracks(id: String) = viewModelScope.launch{
        useCases.getPlaylistTracks(id).collect {
            tracksResponse = it
        }
    }
    fun getFavoriteTracks() = viewModelScope.launch{
        useCases.getFavoriteTracks().collect {
            favoriteTracksResponse = it
        }
    }


    fun addTrack(playlist_id: String, track: Track) = viewModelScope.launch {
        addTrackResponse = Response.Loading
        addTrackResponse = useCases.addTrackToPlaylist(playlist_id, track)
    }

    fun removeTrack(playlist_id: String, id: String) = viewModelScope.launch {
        removeTrackResponse = Response.Loading
        removeTrackResponse = useCases.removeTrackFromPlaylist(playlist_id, id)
        getMyPlaylistTracks(playlist_id)
    }

    fun addFavoriteTrack(track: Track) = viewModelScope.launch {
        addFavoriteTrackResponse = Response.Loading
        addFavoriteTrackResponse = useCases.addTrackToFavorites(track)
        getFavoriteTracks()
    }

    fun removeFavoriteTrack( id: String) = viewModelScope.launch {
        removeFavoriteTrackResponse = Response.Loading
        removeFavoriteTrackResponse = useCases.removeTrackFromFavorites(id)
        getFavoriteTracks()
    }

    fun openDialog(track: Track) {
        openDialog = true
        trackToPlaylist = track
    }
    fun closeDialog() {
        openDialog = false
    }



}
