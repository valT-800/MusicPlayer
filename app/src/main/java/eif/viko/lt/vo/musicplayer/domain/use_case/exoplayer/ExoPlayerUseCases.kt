package eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer

data class ExoPlayerUseCases(
    val initializePlayer: InitializePlayerUseCase,
    val playSelectedTrack: PlaySelectedTrackUseCase,
    val playTrack: PlayTrackUseCase,
    val playNextTrack: PlayNextTrackUseCase,
    val playPreviousTrack: PlayPreviousTrackUseCase
    )
