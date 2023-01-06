package eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddTrackToPlaylist
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.AddTrackToPlaylistAlertDialog
import eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.components.FavoriteTracks
import eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.components.FavoriteTracksContent
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components.RemoveFavoriteTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.PlaylistTopBar

@Composable
fun FavoritesScreen (
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),
    showPlayer: () -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    initializePlayer: (tracks: Tracks) -> Unit,
) {

    Scaffold (
        topBar = {
                 PlaylistTopBar(name = stringResource(id = R.string.favorites_name))
        },
        content = { padding ->
            FavoriteTracks(
                tracksContent = {
                        tracks ->
                    initializePlayer(tracks)
                    FavoriteTracksContent(
                        navController = navController,
                        padding = padding,
                        tracks = tracks,
                        showPlayer = showPlayer,
                        openDialog = {track -> viewModel.openDialog(track)},
                        playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                        removeFavoriteTrack = { id -> viewModel.removeFavoriteTrack(id) },
                        initializePlayer = {initializePlayer(tracks)}
                    )
                    AddTrackToPlaylistAlertDialog(
                        openDialog = viewModel.openDialog,
                        closeDialog = { viewModel.closeDialog() },
                        addTrackToPlaylist = { id, track -> viewModel.addTrack(id, track)},
                        track = viewModel.trackToPlaylist
                    )

                    //deleteTrack = { id -> viewModel.deleteTrack(id) })

                }
            )
        }
    )
    AddFavoriteTrack()
    AddTrackToPlaylist()
    RemoveFavoriteTrack()

}