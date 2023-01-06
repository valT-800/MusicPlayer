package eif.viko.lt.vo.musicplayer.presentation.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.vo.musicplayer.domain.model.Response
import eif.viko.lt.vo.musicplayer.domain.repository.TracksResponse
import eif.viko.lt.vo.musicplayer.domain.use_case.database.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {
    var allTracksResponse by mutableStateOf<TracksResponse>(Response.Loading)
        private set

    init {
        getAllTracks()
    }

    private fun getAllTracks() = viewModelScope.launch{
        useCases.getAllTracks().collect {
            allTracksResponse = it
        }
    }

}