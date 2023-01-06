package eif.viko.lt.vo.musicplayer.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Playlist(
    val id: String = "",
    val images: List<Image> = emptyList(),
    val name: String = "",
    val owner: User = User("", ""),
    val description: String = "",
    //val tracks: List<Track> = emptyList()
)
