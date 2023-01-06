package eif.viko.lt.vo.musicplayer.presentation.ui.player

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.BoolResponse
import eif.viko.lt.vo.musicplayer.domain.repository.TrackResponse
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.ExoPlayerUseCases
import eif.viko.lt.vo.musicplayer.domain.util.Constants.EMPTY_TRACK
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val exoPlayerUseCases: ExoPlayerUseCases
):ViewModel() {
    var showPlayer by mutableStateOf(false)
        private set
    var exoPlayerResponse by mutableStateOf<BoolResponse>(Response.Success(false))
        private set
    var playResponse by mutableStateOf<BoolResponse>(Response.Success(false))
        private set
    var playSelectedResponse by mutableStateOf<BoolResponse>(Response.Success(false))
        private set
    var nextTrackResponse by mutableStateOf<TrackResponse>(Response.Success(EMPTY_TRACK))
        private set
    var previousTrackResponse by mutableStateOf<TrackResponse>(Response.Success(EMPTY_TRACK))
        private set
    var playerState by mutableStateOf(false)

    var selectedTrack by mutableStateOf(EMPTY_TRACK)

    private var playerTracks by mutableStateOf<List<Track>>(emptyList())
        private set


    fun initializePlayer(tracks: Tracks) = viewModelScope.launch {
        exoPlayerResponse = Response.Loading
        exoPlayerResponse = exoPlayerUseCases.initializePlayer(tracks)
        playerTracks = tracks

    }


    fun playSelectedTrack(index: Int, track: Track) = viewModelScope.launch {
        selectedTrack = track
        playSelectedResponse = Response.Loading
        playSelectedResponse = exoPlayerUseCases.playSelectedTrack(index)
        playerState = true

    }

    fun playNextTrack() = viewModelScope.launch {
        nextTrackResponse = Response.Loading
        nextTrackResponse = exoPlayerUseCases.playNextTrack(playerTracks)
    }
    fun playPreviousTrack() = viewModelScope.launch {
        previousTrackResponse = Response.Loading
        previousTrackResponse = exoPlayerUseCases.playPreviousTrack(playerTracks)
    }

    fun play() = viewModelScope.launch {
        playResponse = Response.Loading
        playResponse = exoPlayerUseCases.playTrack()

    }
    fun showPlayer() {
        showPlayer = true
    }
    fun closePlayer() {
        showPlayer = false
    }

}