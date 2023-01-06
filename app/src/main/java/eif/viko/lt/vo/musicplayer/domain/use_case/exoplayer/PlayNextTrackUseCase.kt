package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import androidx.compose.runtime.Composable
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import javax.inject.Inject


class PlayNextTrackUseCase(
    private val player: MyExoPlayer
) {
    suspend operator fun invoke(tracks: Tracks) = player.playNextTrack(tracks)

}