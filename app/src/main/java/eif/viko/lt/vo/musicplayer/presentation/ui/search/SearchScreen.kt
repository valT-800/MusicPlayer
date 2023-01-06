package eif.viko.lt.vo.musicplayer.presentation.ui.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.firestore.admin.v1.Index
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddTrackToPlaylist
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddTrackToPlaylistAlertDialog
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.RemoveFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.search.components.Search
import eif.viko.lt.vo.musicplayer.presentation.ui.search.components.SearchContent

@Composable
fun SearchScreen (
    navController: NavController,
    showPlayer: () -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    initializePlayer: (tracks: Tracks) -> Unit,
    viewModel: PlaylistViewModel = hiltViewModel()
){
    Scaffold (
        content = { padding ->
            Search(
                searchContent = { tracks ->
                    SearchContent(
                        navController = navController,
                        padding = padding,
                        tracks = tracks,
                        showPlayer={showPlayer()},
                        openDialog = {track -> viewModel.openDialog(track)},
                        playSelectedTrack = { index, track -> playSelectedTrack(index, track)},
                        initializePlayer = { filteredTracks -> initializePlayer(filteredTracks)},
                        removeFavoriteTrack = { id -> viewModel.removeFavoriteTrack(id) },
                        addFavoriteTrack = {track -> viewModel.addFavoriteTrack(track)},
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