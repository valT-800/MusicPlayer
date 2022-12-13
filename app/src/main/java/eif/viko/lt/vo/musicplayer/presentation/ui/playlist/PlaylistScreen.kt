package eif.viko.lt.vo.musicplayer.presentation.ui.playlist


import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.ListItem
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components.Player
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun PlaylistScreen(
    navController: NavController,
    viewModel: PlaylistViewModel = hiltViewModel(),

) {

    val state = viewModel.state.tracks
    //var playerState = viewModel.state.exoPlayer
    var track: Track? = null
    ListItem(
        items = state,
        onItemClick = {
            val encodedImageUrl = URLEncoder.encode(it.album.images[0].url , StandardCharsets.UTF_8.toString())
            val encodedSongUrl = URLEncoder.encode(it.preview_url , StandardCharsets.UTF_8.toString())
            navController.navigate(Route.SONG_SCREEN+"/${it.name}/$encodedSongUrl/$encodedImageUrl/${it.artists[0].name}")
            track = it
        }
    )

    Player(//exoPlayer = playerState,
        name = track?.name,
        songUrl = track?.preview_url
    )

}


