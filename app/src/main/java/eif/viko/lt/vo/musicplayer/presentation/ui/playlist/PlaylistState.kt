package eif.viko.lt.vo.musicplayer.presentation.ui.playlist

import com.google.android.exoplayer2.ExoPlayer
import eif.viko.lt.vo.musicplayer.domain.model.Item
import eif.viko.lt.vo.musicplayer.domain.model.Track

data class PlaylistState (
    val tracks: List<Track> = emptyList(),
    //val exoPlayer: ExoPlayer? = null,
    )