package eif.viko.lt.vo.musicplayer.presentation.ui


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
            val encodedImageUrl = URLEncoder.encode(it.album?.images?.get(0)?.url , StandardCharsets.UTF_8.toString())
            navController.navigate(Route.SONG_SCREEN+"/${it.name}/${it.preview_url}/$encodedImageUrl/${it.artists?.get(0)?.name}")
            track = it
            /*playerState?.setMediaItem(MediaItem.Builder().setUri(it.songUrl).setTag(it.title).build())
            playerState?.prepare()
            playerState?.play()
            playerState?.playWhenReady = true*/
        }
    )
    if (track!= null) {

        Player(//exoPlayer = playerState,
            title = track?.name,
            songUrl = track?.preview_url
        )
    }

}


