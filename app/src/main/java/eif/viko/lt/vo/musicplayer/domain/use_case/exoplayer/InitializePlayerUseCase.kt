package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks

class InitializePlayerUseCase(
    private val player: MyExoPlayer
) {
    operator suspend fun invoke(tracks: Tracks) = player.initializePlayer(tracks)
}