package eif.viko.lt.vo.musicplayer.domain.repository

import eif.viko.lt.vo.musicplayer.domain.model.Playlist
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.model.Track
import kotlinx.coroutines.flow.Flow

typealias Playlists = List<Playlist>
typealias PlaylistsResponse = Response<Playlists>
typealias AddPlaylistResponse = Response<Boolean>
typealias DeletePlaylistResponse = Response<Boolean>
typealias ActionResponse = Response<Boolean>
typealias Tracks = List<Track>
typealias TracksResponse = Response<Tracks>
typealias AddTrackResponse = Response<Boolean>
typealias DeleteTrackResponse = Response<Boolean>

interface DatabaseRepository {

    fun getAllTracks(): Flow<TracksResponse>
    fun getMyPlaylists(): Flow<PlaylistsResponse>
    fun getPlaylists(): Flow<PlaylistsResponse>

    suspend fun addPlaylist(name: String): AddPlaylistResponse
    suspend fun deletePlaylist(id: String): DeletePlaylistResponse

    fun getPlaylistTracks(id: String): Flow<TracksResponse>
    fun getMyPlaylistTracks(id: String): Flow<TracksResponse>
    fun getFavoriteTracks(): Flow<TracksResponse>

    suspend fun addTrackToPlaylist(playlist_id: String, track: Track): AddTrackResponse
    suspend fun removeTrackFromPlaylist(playlist_id: String, id: String): DeleteTrackResponse

    suspend fun addTrackToFavorites(track: Track): ActionResponse
    suspend fun removeTrackFromFavorites(id: String): ActionResponse
}