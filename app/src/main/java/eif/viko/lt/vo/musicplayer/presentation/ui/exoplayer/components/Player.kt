package eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components

import android.media.MediaPlayer
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.audio.AudioAttributes
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyExoPlayer
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.GetExoPlayerUseCase
import eif.viko.lt.vo.musicplayer.presentation.ui.exoplayer.ExoPlayerViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistViewModel

@Composable
fun Player(
    viewModel: ExoPlayerViewModel = hiltViewModel(),
    name: String?,
    songUrl: String?
){
    if(songUrl!=null) {
        val exoPlayer = viewModel.state.exoPlayer
        exoPlayer?.setMediaItem(MediaItem.Builder().setUri(songUrl).setTag(name).build())
        exoPlayer?.prepare()
        exoPlayer?.play()
        exoPlayer?.playWhenReady = true
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                if (exoPlayer?.playWhenReady == false) {
                    // IconButton for Start Action
                    IconButton(onClick = { exoPlayer?.playWhenReady = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_play),
                            contentDescription = "",
                            Modifier.size(50.dp)
                        )
                    }
                } else {

                    // IconButton for Pause Action
                    IconButton(onClick = { exoPlayer?.playWhenReady = false }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_pause),
                            contentDescription = "",
                            Modifier.size(50.dp)
                        )
                    }
                }
            }
        }
    }
}


// For displaying preview in
// the Android Studio IDE emulator
/*@Preview (showBackground = true)
@Composable
fun DefaultPreview(viewModel: PlaylistViewModel = hiltViewModel(),) {

    val playerState = viewModel.state.exoPlayer
    Player(exoPlayer = playerState
    )

}*/