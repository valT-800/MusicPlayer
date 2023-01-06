package eif.viko.lt.vo.musicplayer.domain.util

import eif.viko.lt.vo.musicplayer.domain.model.Album
import eif.viko.lt.vo.musicplayer.domain.model.Track

object Constants {
    const val PLAYLISTS = "playlists"
    const val ITEMS = "items"
    const val TRACKS = "tracks"
    const val TRACK = "track"
    const val FAVORITES = "favorites"
    const val USERS = "users"
    val EMPTY_TRACK = Track(Album("", emptyList(), ""), emptyList(), 0, "", "", "")
    const val ID_LENGTH = 22
    const val USER_ID = "pxg99ffu3qg8bjsd0ew1b3ouz"
    const val USER_NAME = "val_ol"
}