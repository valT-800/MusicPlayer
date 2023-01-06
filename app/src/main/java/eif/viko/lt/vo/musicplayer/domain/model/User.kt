package eif.viko.lt.vo.musicplayer.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    val id: String = "",
    val display_name: String = ""
)
