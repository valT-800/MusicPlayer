package eif.viko.lt.vo.musicplayer.presentation.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.presentation.ui.home.components.HomePlaylists
import eif.viko.lt.vo.musicplayer.presentation.ui.home.components.HomePlaylistsContent

@Composable
fun HomeScreen (
    navController: NavController
){
    Scaffold (
        content = { padding ->
            HomePlaylists(
                playlistsContent = { playlists ->
                    HomePlaylistsContent(
                        navController=navController,
                        padding = padding,
                        playlists = playlists
                    )
                }
            )
        }
    )
}