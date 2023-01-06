package eif.viko.lt.vo.musicplayer.presentation.ui.player

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.NextTrackIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.PauseIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.PlayIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.PreviousTrackIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.player.components.Play
import eif.viko.lt.vo.musicplayer.presentation.ui.player.components.PlayNextTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.player.components.PlayPreviousTrack
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun PlayerView (
    navController: NavController,
    //viewModel: PlayerViewModel = hiltViewModel(),
    showPlayer: Boolean,
    playerState: Boolean,
    track: Track,
    play: () -> Unit,
    playNextTrack: () -> Unit,
    playPreviousTrack: () -> Unit,
){

    if (showPlayer) {
        val scrollState = rememberScrollState()
        var shouldAnimate by remember { mutableStateOf(true) }
        LaunchedEffect(key1 = shouldAnimate){
            scrollState.animateScrollTo(
                scrollState.maxValue,
                animationSpec = tween(30000, 10, easing = CubicBezierEasing(0f,0f,0f,0f))
            )
            scrollState.scrollTo(0)
            shouldAnimate= !shouldAnimate
        }
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            elevation = 20.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(70.dp)
                    .clickable {
                        val encodedImageUrl = URLEncoder.encode(
                            track.album.images[0].url,
                            StandardCharsets.UTF_8.toString()
                        )
                        val encodedSongUrl =
                            URLEncoder.encode(track.preview_url, StandardCharsets.UTF_8.toString())
                        navController.navigate(Route.TRACK_SCREEN + "/${track.name}/$encodedSongUrl/$encodedImageUrl/${track.artists[0].name}")
                    },
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row {
                    PreviousTrackIcon(onClick = { playPreviousTrack() },  size = DpSize(40.dp, 40.dp))
                    if (playerState) {
                        // IconButton for Pause Action
                        PauseIcon(onClick = { play() }, size = DpSize(40.dp, 40.dp))
                    } else {
                        // IconButton for Start Action
                        PlayIcon(onClick = { play() }, size = DpSize(40.dp, 40.dp))

                    }
                    NextTrackIcon(onClick = { playNextTrack() }, size = DpSize(40.dp, 40.dp))
                }
                Text(
                    text = track.name + "     "  + track.artists[0].name,
                    modifier = Modifier
                        .weight(1f)
                        .horizontalScroll(scrollState, false),
                    overflow = TextOverflow.Clip,
                    maxLines = 1,

                    )


            }
        }
    }
}