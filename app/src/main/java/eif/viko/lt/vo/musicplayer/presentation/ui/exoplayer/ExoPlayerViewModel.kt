package eif.viko.lt.vo.musicplayer.presentation.ui.exoplayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.GetExoPlayerUseCase
import eif.viko.lt.vo.musicplayer.domain.use_case.firestore.GetSongsUseCase
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
            it?.playWhenReady = false
            state = state.copy(exoPlayer = it)
        }
    }
}