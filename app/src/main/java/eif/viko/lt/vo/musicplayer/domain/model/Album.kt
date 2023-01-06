package eif.viko.lt.vo.musicplayer.domain.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Album(
    val id: String = "",
    val images: List<Image> = emptyList(),
    val name: String = ""

)
