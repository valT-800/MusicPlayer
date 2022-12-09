package eif.viko.lt.vo.musicplayer.data.exoplayer

import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.audio.AudioAttributes

class MyAudioAttributes {
    val audioAttributes = AudioAttributes.Builder()
    .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
    .setUsage(C.USAGE_MEDIA)
    .build()
}