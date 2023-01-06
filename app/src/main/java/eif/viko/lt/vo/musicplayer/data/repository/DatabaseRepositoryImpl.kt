package eif.viko.lt.vo.musicplayer.data.repository


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.snapshotFlow
import com.google.firebase.database.*
import eif.viko.lt.vo.musicplayer.domain.model.*
import eif.viko.lt.vo.musicplayer.domain.repository.*
import eif.viko.lt.vo.musicplayer.domain.util.Constants.FAVORITES
import eif.viko.lt.vo.musicplayer.domain.util.Constants.ID_LENGTH
import eif.viko.lt.vo.musicplayer.domain.util.Constants.ITEMS
import eif.viko.lt.vo.musicplayer.domain.util.Constants.PLAYLISTS
import eif.viko.lt.vo.musicplayer.domain.util.Constants.TRACK
import eif.viko.lt.vo.musicplayer.domain.util.Constants.TRACKS
import eif.viko.lt.vo.musicplayer.domain.util.Constants.USERS
import eif.viko.lt.vo.musicplayer.domain.util.Constants.USER_ID
import eif.viko.lt.vo.musicplayer.domain.util.Constants.USER_NAME
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.Inject


class DatabaseRepositoryImpl @Inject constructor(
    private val reference: DatabaseReference
) : DatabaseRepository {
    var tracks: List<Track> = listOf(Track(
        Album("", listOf(Image("https://i.scdn.co/image/ab67616d0000b273ddab10784fb30109760dcef8")),""),
        listOf(Artist("", "Ethan")),
        210857,  "0xNJLfwntlwTEVXZbmj0PF", "BeStill", "https://p.scdn.co/mp3-preview/cdeac4cc44d07a9130e1ca78afcbb1ccd29ce4be?cid=774b29d4f13844c495f206cafdad9c86"))


    override fun getAllTracks(
    ) = callbackFlow{
        val resultList = ArrayList<Track>()
        reference.child(PLAYLISTS).child(ITEMS).get().addOnCompleteListener {
            val response = if (it.isSuccessful) {
                it.result.children.forEach { snapshotFlow {
                    it.child(TRACKS).child(ITEMS).children.mapNotNull { snapshotFlow {
                        tracks = it.children.mapNotNull { doc ->
                            doc.getValue(Track::class.java)
                            /*val item = doc.getValue(Track::class.java)
                            if (item != null) {
                                resultList.add(item)
                            }*/
                        }
                    }
                    }
                    }
                }
                //tracks = resultList
                Response.Success(tracks)
            } else {
                Response.Failure(it.exception)
            }
            trySend(response)
        }
        awaitClose()
    }


    override fun getPlaylistTracks(
        id: String
    ) = callbackFlow {

        reference.child(PLAYLISTS).child(ITEMS).child(id).child(TRACKS).child(ITEMS).get()
            .addOnCompleteListener { snapshot ->
                val response = if (snapshot.isSuccessful) {
                    tracks = snapshot.result.children.mapNotNull { doc ->
                            doc.getValue(Track::class.java)

                    }
                    Response.Success(tracks)
                } else {
                    Response.Failure(snapshot.exception)
                }
                trySend(response)

            }
        awaitClose()
    }

    override fun getMyPlaylistTracks(
        id: String
    ) = callbackFlow {

        reference.child(USERS).child(USER_ID).child(PLAYLISTS).child(id).child(TRACKS).child(ITEMS).get().addOnCompleteListener { snapshot ->
            val response = if (snapshot.isSuccessful) {
                tracks = snapshot.result.children.mapNotNull{ doc ->
                        doc.getValue(Track::class.java) }
                Response.Success(tracks)
            } else {
                Response.Failure(snapshot.exception)
            }
            trySend(response)
        }
        awaitClose()
    }

    override fun getFavoriteTracks() = callbackFlow {

        reference.child(USERS).child(USER_ID).child(FAVORITES).child(ITEMS).get().addOnCompleteListener { snapshot ->
            val response = if (snapshot.isSuccessful) {
                    tracks = snapshot.result.children.mapNotNull { doc ->
                        doc.getValue(Track::class.java) }
                Response.Success(tracks)
            } else {
                Response.Failure(snapshot.exception)
            }
            trySend(response)
        }
        awaitClose()
    }


    override suspend fun addTrackToPlaylist(
        playlist_id: String,
        track: Track
    ): AddTrackResponse {
        return try{
            reference.child(USERS).child(USER_ID).child(PLAYLISTS).child(playlist_id).child(TRACKS).child(ITEMS).child(track.id).setValue(track)
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }
    }

    override suspend fun removeTrackFromPlaylist(
        playlist_id: String,
        id: String
    ): DeleteTrackResponse {
        return try{
            reference.child(USERS).child(USER_ID).child(PLAYLISTS).child(playlist_id).child(TRACKS).child(ITEMS).child(id).removeValue()
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }
    }

    var items: List<Playlist> = listOf(
        Playlist("hdhgfh", emptyList(),"Playlist", User("w2f3tg", "User")
        )
    )
    override fun getPlaylists() = callbackFlow {

        reference.child(PLAYLISTS).child(ITEMS).get().addOnCompleteListener { snapshot ->
            val playlistsResponse = if (snapshot.isSuccessful) {
                items = snapshot.result.children.mapNotNull { doc ->
                    doc.getValue(Playlist::class.java)
                }
                Response.Success(items)
            } else {
                Response.Failure(snapshot.exception)
            }
            trySend(playlistsResponse)
        }
        awaitClose()

    }

    override fun getMyPlaylists() = callbackFlow {

        reference.child(USERS).child(USER_ID).child(PLAYLISTS).get().addOnCompleteListener { snapshot ->
            val playlistsResponse = if (snapshot.isSuccessful) {
                items = snapshot.result.children.mapNotNull { doc ->
                    doc.getValue(Playlist::class.java)
                }
                Response.Success(items)
            } else {
                Response.Failure(snapshot.exception)
            }
            trySend(playlistsResponse)
        }
        awaitClose()
    }

    override suspend fun addPlaylist(
        name: String
    ): AddPlaylistResponse {
        return try{
            val id = getRandomString()
            val playlist = Playlist(
                id = id,
                name = name,
                //tracks = emptyList(),
                owner = User(USER_ID, USER_NAME),
                description = "",
            )
            reference.child(USERS).child(USER_ID).child(PLAYLISTS).child(id).setValue(playlist)
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }

    }

    override suspend fun deletePlaylist(id: String): DeletePlaylistResponse {
        return try{
            reference.child(USERS).child(USER_ID).child(PLAYLISTS).child(id).removeValue()
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }

    }

    override suspend fun addTrackToFavorites(track: Track): ActionResponse {
        return try{
            reference.child(USERS).child(USER_ID).child(FAVORITES).child(ITEMS).child(track.id).setValue(track)
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }
    }

    override suspend fun removeTrackFromFavorites(id: String): ActionResponse {
        return try{
            reference.child(USERS).child(USER_ID).child(FAVORITES).child(ITEMS).child(id).removeValue()
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }
    }


    private fun getRandomString() : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..ID_LENGTH)
            .map { charset.random() }
            .joinToString("")
    }

}


