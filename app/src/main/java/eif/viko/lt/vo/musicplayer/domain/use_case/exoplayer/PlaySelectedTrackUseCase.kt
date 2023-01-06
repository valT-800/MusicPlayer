package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer

class PlaySelectedTrackUseCase(
    private val player: MyExoPlayer
) {
    suspend operator fun invoke(index: Int) = player.playSelectedTrack(index)

}