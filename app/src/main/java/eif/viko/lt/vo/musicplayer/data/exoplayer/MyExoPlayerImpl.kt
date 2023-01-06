package eif.viko.lt.vo.musicplayer.data.exoplayer


import android.content.Context
import android.util.Log
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.util.MimeTypes
import dagger.hilt.android.qualifiers.ApplicationContext
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.*
import eif.viko.lt.vo.musicplayer.domain.util.Constants.EMPTY_TRACK
import javax.inject.Inject

private const val TAG = "PlayerActivity"

class MyExoPlayerImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val exoPlayer: ExoPlayer
): MyExoPlayer {

    private val playbackStateListener: Player.Listener = playbackStateListener()

    private var playWhenReady = true
    private var currentItem = 0
    private var playbackPosition = 0L

    override suspend fun initializePlayer(tracks: Tracks): BoolResponse {
        return try {
            exoPlayer.apply {
                    clearMediaItems()
                    tracks.forEach { track ->
                        addMediaItem(
                            MediaItem.Builder().setUri(track.preview_url).setMediaId(track.id).setMimeType(MimeTypes.BASE_TYPE_AUDIO).build()
                        )
                }

                //seekTo(currentItem, playbackPosition)
                //seekParameters.
                addListener(playbackStateListener)
                trackSelector

            }
            Response.Success(true)
        }catch (e:Exception){
            Response.Failure(e)
        }

    }
    override suspend fun playNextTrack(tracks: Tracks): TrackResponse {
        return try {
            var track = EMPTY_TRACK
            exoPlayer.apply {
                moveMediaItem(currentMediaItemIndex, nextMediaItemIndex)
                playbackPosition = currentPosition
                currentItem = currentMediaItemIndex
                seekTo(currentItem, playbackPosition)
                seekToNextMediaItem()
                tracks.forEach {
                    if (it.id == currentMediaItem!!.mediaId) {
                        track = it
                    }
                }
            }
            Response.Success(track)
        } catch (e: Exception){
            Response.Failure(e)
        }
    }

    override suspend fun playPreviousTrack(tracks: Tracks): TrackResponse {
        return try {
            var track = EMPTY_TRACK
            exoPlayer.apply {
                moveMediaItem(currentMediaItemIndex, previousMediaItemIndex)
                playbackPosition = currentPosition
                currentItem = currentMediaItemIndex
                seekTo(currentItem, playbackPosition)
                seekToPreviousMediaItem()

                tracks.forEach {
                    if (it.id == currentMediaItem!!.mediaId) {
                        track = it
                    }
                }
            }
            Response.Success(track)
        } catch (e: Exception){
            Response.Failure(e)
        }
    }

    override suspend fun playSelectedTrack(index: Int):BoolResponse {
        return try {
            exoPlayer.apply {
                playWhenReady = false
                moveMediaItem(currentMediaItemIndex, index)
                playbackPosition = currentPosition
                currentItem = currentMediaItemIndex

                seekTo(currentItem, playbackPosition)
                playWhenReady = true
                prepare()
                play()
            }
            Response.Success(true)
        } catch (e: Exception){
            Response.Failure(e)
        }
    }

    override suspend fun playTrack():BoolResponse {
        return try {
            if (exoPlayer.playWhenReady){
                exoPlayer.playWhenReady = false
                exoPlayer.pause()
                playbackPosition = exoPlayer.currentPosition
                currentItem = exoPlayer.currentMediaItemIndex
                //exoPlayer.removeListener(playbackStateListener)
                //exoPlayer.release()
            } else{

                exoPlayer.playWhenReady = true
                exoPlayer.seekTo(currentItem, playbackPosition)
                //exoPlayer.addListener(playbackStateListener)
                exoPlayer.prepare()
                exoPlayer.play()
            }
            Response.Success(exoPlayer.playWhenReady)
        } catch (e: Exception){
            Response.Failure(e)
        }
    }


}

private fun playbackStateListener() = object : Player.Listener {
    override fun onPlaybackStateChanged(playbackState: Int) {
        val stateString: String = when (playbackState) {
            ExoPlayer.STATE_IDLE -> "ExoPlayer.STATE_IDLE      -"
            ExoPlayer.STATE_BUFFERING -> "ExoPlayer.STATE_BUFFERING -"
            ExoPlayer.STATE_READY -> "ExoPlayer.STATE_READY     -"
            ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED     -"
            else -> "UNKNOWN_STATE             -"
        }
        Log.d(TAG, "changed state to $stateString")
    }
}