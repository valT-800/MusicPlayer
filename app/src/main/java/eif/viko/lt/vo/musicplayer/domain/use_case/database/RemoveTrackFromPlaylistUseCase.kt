package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class RemoveTrackFromPlaylistUseCase (
    private val repository: DatabaseRepository
){
    suspend operator fun invoke(
        playlist_id: String,
        id: String
    ) = repository.removeTrackFromPlaylist(playlist_id, id)
}