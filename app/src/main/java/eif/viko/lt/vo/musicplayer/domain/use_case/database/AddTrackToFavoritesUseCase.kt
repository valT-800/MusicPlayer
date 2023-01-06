package eif.viko.lt.vo.musicplayer.domain.use_case.database

import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

class AddTrackToFavoritesUseCase (
    private val repository: DatabaseRepository
){
    suspend operator fun invoke(
        track: Track
    ) = repository.addTrackToFavorites(track)
}