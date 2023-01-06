package eif.viko.lt.vo.musicplayer.di

import android.content.Context
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyExoPlayerImpl
import eif.viko.lt.vo.musicplayer.domain.repository.MyExoPlayer
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ExoPlayerModule {


    @Singleton
    @Provides
    fun provideAudioAttributes() = AudioAttributes.Builder()
            .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()

    @Singleton
    @Provides
    fun provideExoPlayer(
        @ApplicationContext context: Context,
        audioAttributes: AudioAttributes
    ) = ExoPlayer.Builder(context)
        .build().apply{
            setAudioAttributes(audioAttributes, true)
            setHandleAudioBecomingNoisy(true)
        }



    @Singleton
    @Provides
    fun provideMyExoPlayer(
        @ApplicationContext context: Context,
        exoPlayer: ExoPlayer
    ): MyExoPlayer {
        return MyExoPlayerImpl(context, exoPlayer)
    }

    @Singleton
    @Provides
    fun provideUseCases(myExoPlayer: MyExoPlayer) = ExoPlayerUseCases(
        initializePlayer = InitializePlayerUseCase(myExoPlayer),
        playTrack = PlayTrackUseCase(myExoPlayer),
        playSelectedTrack = PlaySelectedTrackUseCase(myExoPlayer),
        playNextTrack = PlayNextTrackUseCase(myExoPlayer),
        playPreviousTrack = PlayPreviousTrackUseCase(myExoPlayer)
    )

}