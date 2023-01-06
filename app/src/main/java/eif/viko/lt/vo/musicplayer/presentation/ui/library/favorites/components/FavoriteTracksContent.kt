package eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.HomeTrackCard

@Composable
fun FavoriteTracksContent (
    navController: NavController,
    padding: PaddingValues,
    tracks: Tracks,
    showPlayer: () -> Unit,
    openDialog: (Track) -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    removeFavoriteTrack: (id: String) -> Unit,
    initializePlayer: () -> Unit

    ){
    Scaffold(
        content = { padding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ){
                items(
                    items = tracks
                ){
                        track ->
                    FavoriteTrackCard(
                        track = track,
                        removeFavoriteTrack = { id -> removeFavoriteTrack(id) },
                        openDialog = {track -> openDialog(track)},
                        onItemClick = {
                            initializePlayer()
                            showPlayer()
                            playSelectedTrack(tracks.indexOf(track), track)

                        }
                        /*deleteTrack = {
                            track.id?.let { id ->
                                deleteTrack(id)
                            }
                        }*/
                    )
                }
            }
        }
    )


}