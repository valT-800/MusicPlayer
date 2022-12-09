package eif.viko.lt.vo.musicplayer.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.snapshotFlow
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.database.ktx.snapshots
import eif.viko.lt.vo.musicplayer.domain.model.Item
import eif.viko.lt.vo.musicplayer.domain.repository.DatabaseRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val reference: DatabaseReference
) : DatabaseRepository {
    override fun getItems(): Flow<List<Item>> {

        reference.child("items").snapshots.mapNotNull {
            for (snapshot in it.children){
                    it.getValue(Item::class.java)
                }
        }
}

