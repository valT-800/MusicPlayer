package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository
import javax.inject.Inject

class GetMyPlaylistsUseCase(
    private val repository: DatabaseRepository
) {
    operator fun invoke() = repository.getMyPlaylists()
}