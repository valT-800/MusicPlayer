package eif.viko.lt.vo.musicplayer.presentation.ui.playlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.use_case.database.GetItemsUseCase
import eif.viko.lt.vo.musicplayer.domain.use_case.exoplayer.GetExoPlayerUseCase
import eif.viko.lt.vo.musicplayer.domain.use_case.firestore.GetSongsUseCase
//import eif.viko.lt.vo.musicplayer.domain.use_case.GetMusicPlayerSongsUseCase
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val getSongsUseCase: GetSongsUseCase,
    private val getExoPlayerUseCase: GetExoPlayerUseCase,
    private val getItemsUseCase: GetItemsUseCase,
):ViewModel(){

    var state by mutableStateOf(PlaylistState())
        private set

    /*private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UIEvent{
        data class ShowSnackbar(val message: String): UIEvent()
    }*/
    init {
        getSongs()
        getExoPlayer()
        getItems()
    }

    private fun getSongs(){
        getSongsUseCase().onEach {
            state = state.copy(tracks = it)
        }.launchIn(viewModelScope)
    }
    private fun getExoPlayer(){
        getExoPlayerUseCase().also {
            //it?.prepare()
            //it?.play()
            it?.playWhenReady = false
            state = state.copy(exoPlayer = it)
        }
    }

    private fun getItems(){
        getItemsUseCase().onEach {
            state = state.copy(items = it)
        }.launchIn(viewModelScope)
    }
//.addMediaItem(MediaItem.Builder().setUri(it.songUrl).setTag(it.title).build())

    /*private fun  getSongs() {
        getMusicPlayerSongsUseCase().onEach { result ->
            state = when (result){
                is Resource.Success -> {
                    state.copy(
                        songs = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    state.copy(
                        songs = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Loading -> {
                    state.copy(
                        songs = result.data ?: emptyList(),
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }*/
}