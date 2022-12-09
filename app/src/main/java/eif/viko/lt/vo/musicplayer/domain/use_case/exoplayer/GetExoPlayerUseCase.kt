package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import com.google.android.exoplayer2.ExoPlayer
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyExoPlayer
import javax.inject.Inject

class GetExoPlayerUseCase @Inject constructor(
    private val exoPlayer: MyExoPlayer
) {
    operator fun invoke(): ExoPlayer {
        return exoPlayer.getExoPlayer()
    }
}