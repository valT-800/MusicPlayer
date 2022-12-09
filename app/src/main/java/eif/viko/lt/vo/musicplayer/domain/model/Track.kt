package eif.viko.lt.vo.musicplayer.domain.model

import android.net.Uri
import android.support.v4.media.MediaMetadataCompat

data class Track (
    val album: Album?,
    val artists: List<Artist>?,
    val duration_ms: Int = 0,
    val href: String = "",
    val id: Int =0,
    val name: String = "",
    val preview_url: String = ""
    )
