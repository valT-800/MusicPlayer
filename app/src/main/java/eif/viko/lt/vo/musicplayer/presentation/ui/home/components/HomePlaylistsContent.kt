package eif.viko.lt.vo.musicplayer.presentation.ui.home.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.repository.Playlists
import eif.viko.lt.vo.musicplayer.domain.util.Route

@Composable
fun HomePlaylistsContent (
    navController: NavController,
    padding: PaddingValues,
    playlists: Playlists
){
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ){
        items(
            items = playlists
        ){
            playlist ->
            HomePlaylistCard(
                playlist = playlist,
                onItemClick = {
                    navController.navigate(Route.HOME_PLAYLIST_SCREEN + "/${playlist.id}/${playlist.name}")
                }
            )
        }
    }
}