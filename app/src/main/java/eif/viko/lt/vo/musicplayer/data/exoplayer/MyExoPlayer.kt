package eif.viko.lt.vo.musicplayer.data.exoplayer


import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface MyExoPlayer{
    fun getExoPlayer(): ExoPlayer
}