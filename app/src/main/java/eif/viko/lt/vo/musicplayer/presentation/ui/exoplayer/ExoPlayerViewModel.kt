package eif.viko.lt.vo.musicplayer.presentation.ui.exoplayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.GetExoPlayerUseCase
import javax.inject.Inject

@HiltViewModel
class ExoPlayerViewModel @Inject constructor(
    private val getExoPlayerUseCase: GetExoPlayerUseCase,
): ViewModel() {

    var state by mutableStateOf(ExoPlayerState())
        private set

    /*private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UIEvent{
        data class ShowSnackbar(val message: String): UIEvent()
    }*/
    init {
        getExoPlayer()
    }

    private fun getExoPlayer() {
        getExoPlayerUseCase().also {
            //it?.prepare()
            //it?.play()
            it.playWhenReady = false
            state = state.copy(exoPlayer = it)
        }
    }
}