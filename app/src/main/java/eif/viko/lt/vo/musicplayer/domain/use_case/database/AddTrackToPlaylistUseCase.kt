package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class AddTrackToPlaylistUseCase (
    private val repository: DatabaseRepository
){
    suspend operator fun invoke(
        playlist_id: String,
        track: Track
    ) = repository.addTrackToPlaylist(playlist_id, track)
}
