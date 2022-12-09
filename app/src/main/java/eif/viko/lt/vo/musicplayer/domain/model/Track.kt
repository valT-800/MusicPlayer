package eif.viko.lt.vo.musicplayer.domain.model

import android.net.Uri
import android.support.v4.media.MediaMetadataCompat

data class Track (
    val name: String = "",
    val preview_url: String = "",
    val imageUrl: String = "",
    val artist: Artist,
    val duration_ms: Int = 0,
    val uri: Uri?,
    val href: String = "",
    val album: Album

    )
