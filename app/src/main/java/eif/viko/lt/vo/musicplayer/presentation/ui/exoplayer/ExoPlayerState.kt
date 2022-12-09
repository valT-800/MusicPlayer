package eif.viko.lt.vo.musicplayer.presentation.ui.exoplayer

import com.google.android.exoplayer2.ExoPlayer

data class ExoPlayerState (
    val exoPlayer: ExoPlayer? = null,
    val isPlaying: Boolean = false,
    //val error: String? = null
        )