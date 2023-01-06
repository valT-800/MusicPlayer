package eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firestore.admin.v1.Index
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.PlayFloatingActionButton
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.*
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.RemoveFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.PlaylistTopBar

@Composable
fun HomePlaylistScreen(
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),
    id: String?,
    name: String?,
    showPlayer: () -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    initializePlayer: (tracks: Tracks) -> Unit
) {
    viewModel.getPlaylistTracks(id!!)

    Scaffold (
        topBar = {
            if (name != null) {
                PlaylistTopBar(name = name )
            }
        },
        content = { padding ->
            HomeTracks(
                tracksContent = {
                        tracks ->
                    HomeTracksContent(
                        navController = navController,
                        padding = padding,
                        tracks = tracks,
                        showPlayer = { showPlayer() },
                        openDialog = {track -> viewModel.openDialog(track)},
                        playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                        removeFavoriteTrack = { id -> viewModel.removeFavoriteTrack(id) },
                        addFavoriteTrack = {track -> viewModel.addFavoriteTrack(track)},
                        initializePlayer = { initializePlayer(tracks)}
                    )

                }
            )
            AddTrackToPlaylistAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = { viewModel.closeDialog() },
                addTrackToPlaylist = { id, track -> viewModel.addTrack(id, track)},
                track = viewModel.trackToPlaylist
            )
        }
    )
    AddFavoriteTrack()
    AddTrackToPlaylist()
    RemoveFavoriteTrack()
}