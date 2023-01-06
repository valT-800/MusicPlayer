package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class RemoveTrackFromFavoritesUseCase (
    private val repository: DatabaseRepository
){
    suspend operator fun invoke(
        id: String
    ) = repository.removeTrackFromFavorites(id)
}