package eif.viko.lt.vo.musicplayer.domain.model

import android.net.Uri
import android.support.v4.media.MediaMetadataCompat
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Track (
    val album: Album = Album("", emptyList(),""),
    val artists: List<Artist> = emptyList(),
    val duration_ms: Long = 0,
    val id: String ="",
    val name: String = "",
    val preview_url: String = ""
    )/*{
    fun toTrack(): Track {
        return Track(
            duration_ms = duration_ms,
            href = href,
            id = id,
            name = name,
            preview_url = preview_url

        )
    }
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "duration_ms" to duration_ms,
            "href" to href,
            "id" to id,
            "name" to name,
            "preview_url" to preview_url
        )
    }
}
*/