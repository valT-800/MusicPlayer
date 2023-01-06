package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.model.User
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class AddPlaylistUseCase (
    private val repository: DatabaseRepository
        ){
    suspend operator fun invoke(
        name: String
    ) = repository.addPlaylist(name)
}