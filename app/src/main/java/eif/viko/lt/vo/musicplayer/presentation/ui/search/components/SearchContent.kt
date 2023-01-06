package eif.viko.lt.vo.musicplayer.presentation.ui.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.domain.util.Constants
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.components.HomeTrackCard
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun SearchContent (
    navController: NavController,
    padding: PaddingValues,
    tracks: Tracks,
    showPlayer: () -> Unit,
    openDialog: (Track) -> Unit,
    playSelectedTrack:(index: Int, track: Track)->Unit,
    initializePlayer: (tracks: Tracks) -> Unit,
    removeFavoriteTrack: (id: String) -> Unit,
    addFavoriteTrack: (track: Track) -> Unit,


    ){
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    var track = remember { mutableStateOf(Constants.EMPTY_TRACK) }

    val filteredItems: List<Track>
    val searchedText = textState.value.text
    val filterPattern = searchedText.lowercase(Locale.getDefault())
    filteredItems = if (searchedText.isEmpty()) {
        emptyList()
    } else {
        val resultList = ArrayList<Track>()
        for (item in tracks) {
            if (item.name.lowercase(Locale.getDefault()).contains(filterPattern)
                || item.artists[0].name.lowercase(Locale.getDefault()).contains(filterPattern)
            ) {
                resultList.add(item)
            }
        }
        resultList
    }
    Scaffold(
        topBar = {SearchView(textState)},
        content = { padding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ){
                items(
                    items = filteredItems
                ){
                        track ->
                    HomeTrackCard(
                        track = track,
                        removeFavoriteTrack = { removeFavoriteTrack(track.id) },
                        addFavoriteTrack = {addFavoriteTrack(track)},
                        openDialog = {openDialog(track)},
                        onItemClick = {
                            initializePlayer(filteredItems)
                            showPlayer()
                            playSelectedTrack(filteredItems.indexOf(track), track)
                        }

                    )
                }
            }
        }
    )


}

