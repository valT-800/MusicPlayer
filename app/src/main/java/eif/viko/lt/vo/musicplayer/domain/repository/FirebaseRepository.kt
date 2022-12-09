package eif.viko.lt.vo.musicplayer.domain.repository

import eif.viko.lt.vo.musicplayer.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun getSongs(): Flow<List<Track>>
}