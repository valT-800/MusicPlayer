package eif.viko.lt.vo.musicplayer.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Artist(
    val id: String = "",
    val name: String = ""
)
