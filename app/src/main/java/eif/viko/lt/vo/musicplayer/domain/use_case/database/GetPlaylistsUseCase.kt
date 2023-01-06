package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.model.Playlist
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlaylistsUseCase (
    private val repository: DatabaseRepository
) {
    operator fun invoke() = repository.getPlaylists()
}