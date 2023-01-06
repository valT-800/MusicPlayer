package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class GetAllTracksUseCase (
    private val repository: DatabaseRepository
) {
    operator fun invoke() = repository.getAllTracks()
}