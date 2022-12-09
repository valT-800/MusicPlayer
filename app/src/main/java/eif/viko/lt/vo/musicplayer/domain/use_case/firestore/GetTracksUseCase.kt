package eif.viko.lt.vo.musicplayer.domain.use_case.firestore

import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTracksUseCase @Inject constructor(
    private val repository: FirebaseRepository
) {
    operator fun invoke(): Flow<List<Track>>{
        return repository.getTracks()
    }
}