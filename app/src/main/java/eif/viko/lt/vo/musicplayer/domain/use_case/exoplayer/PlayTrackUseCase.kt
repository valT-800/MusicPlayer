package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer
import javax.inject.Inject

class PlayTrackUseCase(
    private val player: MyExoPlayer
) {
    suspend operator fun invoke() = player.playTrack()

}