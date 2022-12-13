package eif.viko.lt.vo.musicplayer.data.repository


import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.ktx.snapshots
import com.google.firebase.firestore.util.Assert
import eif.viko.lt.vo.musicplayer.domain.model.*
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository

import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class DatabaseRepositoryImpl @Inject constructor(
    private val reference: DatabaseReference
) : DatabaseRepository {

    override fun getTracks(): Flow<List<Track>> {
        var items: List<Track> = listOf(Track(
            Album("", listOf(Image("https://i.scdn.co/image/ab67616d0000b273ddab10784fb30109760dcef8")),""),
            listOf(Artist("", "Ethan")),
            210857, "https://api.spotify.com/v1/tracks/0xNJLfwntlwTEVXZbmj0PF", "0xNJLfwntlwTEVXZbmj0PF", "BeStill", "https://p.scdn.co/mp3-preview/cdeac4cc44d07a9130e1ca78afcbb1ccd29ce4be?cid=774b29d4f13844c495f206cafdad9c86"))

/*reference.child("tracks").snapshots.map{ it.children.toTrack()
    for (snapshot in it.children) {
       val item = snapshot.value.toTrack()
        if (item != null) {
            items.add(item)
        }
    }
}
return flow { emit(items.toList()) }*/
        reference.child("tracks").get().addOnCompleteListener {
            if (it.isSuccessful) {
                items = it.result.children.mapNotNull { doc ->
                    doc.getValue(Track::class.java)
                }
            } else {
                Log.d(TAG, it.exception?.message.toString())
            }
        }
        return flow {  emit(items)  }
    }

}

