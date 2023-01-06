package eif.viko.lt.vo.musicplayer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firestore.admin.v1.Index
import eif.viko.lt.vo.musicplayer.domain.model.Track
import eif.viko.lt.vo.musicplayer.domain.repository.Tracks
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.home.HomeScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.home.playlist.HomePlaylistScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.library.LibraryScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.library.favorites.FavoritesScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.library.playlist.LibraryPlaylistScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.player.PlayerViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.player.components.PlaySelectedTrack
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.TrackScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.search.SearchScreen


@Composable
fun MyAppNavHost (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.HOME_SCREEN,
    showPlayer: () -> Unit,
    playSelectedTrack: (index: Int, track: Track) -> Unit,
    //viewModel: PlayerViewModel = hiltViewModel(),
    initializePlayer: (tracks: Tracks) -> Unit
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination){
        composable(route = Route.HOME_SCREEN){
            HomeScreen(navController = navController)
        }
        composable(route = Route.SEARCH_SCREEN){
            SearchScreen(
                navController = navController,
                showPlayer = { showPlayer() },
                playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                initializePlayer = { tracks ->  initializePlayer(tracks)}
            )
        }
        composable(route = Route.LIBRARY_SCREEN){
            LibraryScreen(navController = navController)
        }
        composable(
            route = "${Route.LIBRARY_PLAYLIST_SCREEN}/{id}/{name}",
            arguments = listOf(
                navArgument("id"){type = NavType.StringType},
                navArgument("name"){type = NavType.StringType}
            )
        ){backStackEntry ->
        LibraryPlaylistScreen(
            navController = navController,
            showPlayer = { showPlayer() },
            playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
            initializePlayer = { tracks -> initializePlayer(tracks)},
            id = backStackEntry.arguments?.getString("id"),
            name = backStackEntry.arguments?.getString("name"),
        )
        }
        composable(route = Route.FAVORITES_SCREEN){
            FavoritesScreen(
                navController = navController,
                showPlayer = { showPlayer() },
                playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                initializePlayer = { tracks -> initializePlayer(tracks)},
            )
        }
        composable(
            route = "${Route.HOME_PLAYLIST_SCREEN}/{id}/{name}",
            arguments = listOf(
                navArgument("id"){type = NavType.StringType},
                navArgument("name"){type = NavType.StringType},
            )){backStackEntry ->
            HomePlaylistScreen(
                navController = navController,
                showPlayer = { showPlayer() },
                playSelectedTrack = {index, track -> playSelectedTrack(index, track)},
                initializePlayer = { tracks -> initializePlayer(tracks)},
                id = backStackEntry.arguments?.getString("id"),
                name = backStackEntry.arguments?.getString("name"),
            )
        }
        composable(
            route = "${Route.TRACK_SCREEN}/{name}/{preview_url}/{imageUrl}/{artist_name}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("preview_url"){type = NavType.StringType},
                navArgument("imageUrl"){type = NavType.StringType},
                navArgument("artist_name"){type = NavType.StringType}
            )){backStackEntry ->
                TrackScreen(
                    navController = navController,
                    name = backStackEntry.arguments?.getString("name"),
                    preview_url = backStackEntry.arguments?.getString("preview_url"),
                    imageUrl = backStackEntry.arguments?.getString("imageUrl"),
                    artist_name = backStackEntry.arguments?.getString("artist_name")
                )
        }


    }
}