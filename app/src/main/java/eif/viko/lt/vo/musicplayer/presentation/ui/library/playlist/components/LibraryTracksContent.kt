package eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks

@Composable
fun LibraryTracksContent (
    navController: NavController,
    padding: PaddingValues,
    tracks: Tracks,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    showPlayer: () -> Unit,
    removeTrack: (id: String) -> Unit,
    removeFavoriteTrack: (id: String) -> Unit,
    addFavoriteTrack: (track: Track) -> Unit,
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
                    LibraryTrackCard(
                        track = track,
                        removeTrack = {id -> removeTrack(id)},
                        removeFavoriteTrack = { id -> removeFavoriteTrack(id) },
                        addFavoriteTrack = {addFavoriteTrack(track)},
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