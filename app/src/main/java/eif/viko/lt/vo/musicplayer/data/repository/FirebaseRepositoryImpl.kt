package eif.viko.lt.vo.musicplayer.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FirebaseRepository {
    override fun getTracks(): Flow<List<Track>> {
        return try {
            return firestore
                .collection("songs")
                .snapshots()
                .map { it.toObjects(Track::class.java) }
        } catch(e: Exception) {
            emptyFlow()

        }

    }
}