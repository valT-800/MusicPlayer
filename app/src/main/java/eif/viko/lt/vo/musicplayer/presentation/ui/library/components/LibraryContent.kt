package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.repository.Playlists
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.AddIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.player.PlayerViewModel

@Composable
fun LibraryContent (
    navController: NavController,
    padding: PaddingValues,
    viewModel: PlayerViewModel = hiltViewModel(),
    playlists: Playlists,
    deletePlaylist: (id: String) -> Unit,
    openDialog: () -> Unit
){
    Scaffold(
        topBar = {
            LibraryTopBar()
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                FavoritesCard(
                    onItemClick = {
                        navController.navigate(Route.FAVORITES_SCREEN)
                        viewModel.showPlayer()
                    })
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding)
                ) {
                    items(
                        items = playlists,
                    ) { playlist ->
                        LibraryPlaylistCard(
                            playlist = playlist,
                            deletePlaylist = {
                                playlist.id?.let { id ->
                                    deletePlaylist(id)
                                }
                            },
                            onItemClick = {
                                navController.navigate(Route.LIBRARY_PLAYLIST_SCREEN + "/${playlist.id}/${playlist.name}")
                                viewModel.showPlayer()
                            }


                        )
                    }
                }
                Card() {
                    AddIcon(onClick = { openDialog() }, size = DpSize(60.dp, 60.dp))}
                }


        }
    )

}