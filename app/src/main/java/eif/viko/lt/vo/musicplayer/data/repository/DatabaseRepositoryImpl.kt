package eif.viko.lt.vo.musicplayer.data.repository


import android.util.Log
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.ktx.snapshots
import com.google.firebase.firestore.util.Assert
import eif.viko.lt.vo.musicplayer.domain.model.Item
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class DatabaseRepositoryImpl @Inject constructor(
    private val reference: DatabaseReference
) : DatabaseRepository {
    override fun getTracks(): Flow<List<Track>> {
        val items = ArrayList<Track>()
        reference.child("tracks").snapshots.map{
            for (snapshot in it.children) {
               val item = snapshot.getValue(Track::class.java)
                if (item != null) {
                    items.add(item)
                }
            }
        }
        val tracks = items.toList()
        return flow { emit(tracks) }
    }
}

