package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class GetMyPlaylistTracksUseCase(
    private val repository: DatabaseRepository
) {
    operator fun invoke(
        id: String
    ) = repository.getMyPlaylistTracks(id)
}