package eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firestore.admin.v1.Index
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks

@Composable
fun HomeTracksContent (
    navController: NavController,
    padding: PaddingValues,
    tracks: Tracks,
    showPlayer: () -> Unit,
    openDialog: (Track) -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    removeFavoriteTrack: (id: String) -> Unit,
    addFavoriteTrack: (track: Track) -> Unit,
    initializePlayer: ()-> Unit

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
                    HomeTrackCard(
                        track = track,
                        removeFavoriteTrack = { removeFavoriteTrack(track.id) },
                        addFavoriteTrack = {addFavoriteTrack(track)},
                        openDialog = {openDialog(track)},
                        onItemClick = {
                            initializePlayer()
                            showPlayer()
                            playSelectedTrack(tracks.indexOf(track), track)

                        }
                    )
                }
            }
        }
    )


}