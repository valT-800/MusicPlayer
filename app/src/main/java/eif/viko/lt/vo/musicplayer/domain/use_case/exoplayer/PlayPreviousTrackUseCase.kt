package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks

class PlayPreviousTrackUseCase (
    private val player: MyExoPlayer
) {
    suspend operator fun invoke(tracks: Tracks) = player.playNextTrack(tracks)

}