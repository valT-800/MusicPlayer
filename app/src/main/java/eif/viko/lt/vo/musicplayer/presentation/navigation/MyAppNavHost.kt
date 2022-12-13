package eif.viko.lt.vo.musicplayer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.PlaylistScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.playlist.SongScreen
import eif.viko.lt.vo.musicplayer.presentation.ui.search.SearchScreen


@Composable
fun MyAppNavHost (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.SONGS_SCREEN
){
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination){
        composable(route = Route.SONGS_SCREEN){
            PlaylistScreen(navController = navController)
        }
        composable(
            route = "${Route.SONG_SCREEN}/{name}/{preview_url}/{imageUrl}/{artist_name}",
            arguments = listOf(
                navArgument("name"){type = NavType.StringType},
                navArgument("preview_url"){type = NavType.StringType},
                navArgument("imageUrl"){type = NavType.StringType},
                navArgument("artist_name"){type = NavType.StringType}
            )){backStackEntry ->
                SongScreen(
                    navController = navController,
                    name = backStackEntry.arguments?.getString("name"),
                    preview_url = backStackEntry.arguments?.getString("preview_url"),
                    imageUrl = backStackEntry.arguments?.getString("imageUrl"),
                    artist_name = backStackEntry.arguments?.getString("artist_name")
                )
        }
        composable(
            route = Route.HOME_SCREEN){
            PlaylistScreen(navController = navController)
        }
        composable(
            route = Route.SEARCH_SCREEN
        ){
            SearchScreen(navController = navController)
        }
        composable(
            route = Route.LIBRARY_SCREEN
        ){
            PlaylistScreen(navController = navController)
        }
    }
}