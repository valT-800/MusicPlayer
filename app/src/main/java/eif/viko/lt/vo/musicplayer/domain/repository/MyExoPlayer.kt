package eif.viko.lt.vo.musicplayer.domain.repository


import com.google.android.exoplayer2.ExoPlayer
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.model.Track
import kotlinx.coroutines.flow.Flow

typealias ExoPlayerResponse = Response<ExoPlayer>
typealias TrackResponse = Response<Track>
typealias BoolResponse = Response<Boolean>

interface MyExoPlayer{
    suspend fun initializePlayer(tracks: Tracks): BoolResponse
    suspend fun playNextTrack(tracks: Tracks): TrackResponse
    suspend fun playPreviousTrack(tracks: Tracks): TrackResponse
    suspend fun playTrack(): BoolResponse
    suspend fun playSelectedTrack(index: Int): BoolResponse
}