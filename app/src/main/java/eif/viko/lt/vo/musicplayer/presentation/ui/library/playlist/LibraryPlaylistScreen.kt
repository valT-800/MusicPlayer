package eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist


import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddTrackToPlaylist
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.LibraryTracks
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.LibraryTracksContent
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.RemoveFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.RemoveTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.PlaylistTopBar

@Composable
fun LibraryPlaylistScreen(
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),
    id: String?,
    name: String?,
    showPlayer: () -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    initializePlayer: (tracks: Tracks) -> Unit
) {
    viewModel.getMyPlaylistTracks(id!!)
    Scaffold (
        topBar = {
            if (name != null) {
                PlaylistTopBar(name = name)
            }
        },
        content = { padding ->
            LibraryTracks(
                tracksContent = {
                        tracks ->
                    LibraryTracksContent(
                        navController = navController,
                        padding = padding,
                        tracks = tracks,
                        showPlayer = showPlayer,
                        playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                        removeTrack = {track_id -> viewModel.removeTrack(id, track_id)},
                        removeFavoriteTrack = { id -> viewModel.removeFavoriteTrack(id) },
                        addFavoriteTrack = {track -> viewModel.addFavoriteTrack(track)},
                        initializePlayer = { initializePlayer(tracks)}
                    )

                }
            )
        }
    )
    RemoveTrack()
    AddFavoriteTrack()
    RemoveFavoriteTrack()

}


