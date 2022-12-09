package eif.viko.lt.vo.musicplayer.di

import android.content.Context
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyAudioAttributes
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyExoPlayer
import eif.viko.lt.vo.musicplayer.data.exoplayer.MyExoPlayerImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ExoPlayerModule {

    @Singleton
    @Provides
    fun provideAudioAttributes(): AudioAttributes {
        return AudioAttributes.Builder()
            .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
            .setUsage(C.USAGE_MEDIA)
            .build()
    }



    /*@Singleton
    @Provides
    fun provideExoPlayer(
        audioAttributes: AudioAttributes,
        @ApplicationContext context: Context,
        mediaSourceFactory: DefaultMediaSourceFactory,
    ): ExoPlayer {
        return ExoPlayer.Builder(context)
            .setMediaSourceFactory(mediaSourceFactory)
            .build().apply{
                setAudioAttributes(audioAttributes, true)
                setHandleAudioBecomingNoisy(true)
            }

    }*/

/*
    @Singleton
    @Provides
    fun provideAudioAttributes(): MyAudioAttributes {
        return MyAudioAttributes()
    }*/



    @Singleton
    @Provides
    fun provideExoPlayer(
        @ApplicationContext context: Context,
    ): MyExoPlayer {
        return MyExoPlayerImpl(context)

    }
}