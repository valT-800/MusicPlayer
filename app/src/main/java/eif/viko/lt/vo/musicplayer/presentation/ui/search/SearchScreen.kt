package eif.viko.lt.vo.musicplayer.presentation.ui.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Item
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.ListItem
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.Player
import eif.viko.lt.vo.musicplayer.presentation.ui.search.components.SearchView
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun SearchScreen (
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),

){
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    var track: Track? = null
    val items = viewModel.state.tracks
    
    SearchView(textState)

    val filteredItems: List<Track>
    val searchedText = textState.value.text
    val filterPattern = searchedText.lowercase(Locale.getDefault())
    filteredItems = if (searchedText.isEmpty()) {
        items
    } else {
        val resultList = ArrayList<Track>()
        for (item in items) {
            if (item.name.lowercase(Locale.getDefault()).contains(filterPattern)
                || item.artists[0].name.lowercase(Locale.getDefault())!!.contains(filterPattern)
            ) {
                resultList.add(item)
            }
        }
        resultList
    }
    ListItem(
        items = filteredItems,
        onItemClick = {
            val encodedImageUrl = URLEncoder.encode(it.album.images[0].url , StandardCharsets.UTF_8.toString())
            val encodedSongUrl = URLEncoder.encode(it.preview_url , StandardCharsets.UTF_8.toString())
            navController.navigate(Route.SONG_SCREEN+"/${it.name}/$encodedSongUrl/$encodedImageUrl/${it.artists[0].name}")
            track = it
        }
    )

    Player(
        name = track!!.name,
        songUrl = track!!.preview_url
    )
}