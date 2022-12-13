package eif.viko.lt.vo.musicplayer.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.navigation.MyAppNavHost
import eif.viko.lt.vo.musicplayer.presentation.ui.theme.MusicPlayerTheme
import eif.viko.lt.vo.player.ui.components.layouts.AppBar
import eif.viko.lt.vo.player.ui.components.layouts.DrawerBody
import eif.viko.lt.vo.player.ui.components.layouts.DrawerHeader
import eif.viko.lt.vo.player.ui.components.layouts.MenuItem
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicPlayerTheme {
                val dummyList = listOf(
                    MenuItem(
                        Route.SONGS_SCREEN,
                        "Songs",
                        "All songs",
                        Icons.Default.Person


                    )
                )
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )

                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {

                        DrawerHeader()
                        DrawerBody(items = dummyList, onItemClick = {

                            navController.navigate(it.id)

                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        })
                    },
                    bottomBar = {
                        BottomAppBar(
                            content = {
                                IconButton(onClick = { navController.navigate(Route.SEARCH_SCREEN) }) {
                                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "")

                                }
                                Spacer(modifier = Modifier.width(90.dp))
                                IconButton(onClick = { navController.navigate(Route.HOME_SCREEN) }) {
                                    Icon(painter = painterResource(id = R.drawable.ic_home), contentDescription = "")

                                }
                                Spacer(modifier = Modifier.width(90.dp))
                                IconButton(onClick = { navController.navigate(Route.LIBRARY_SCREEN) }) {
                                    Icon(painter = painterResource(id = R.drawable.ic_library), contentDescription = "")

                                }
                            }
                        )
                    }
                ) {
                    MyAppNavHost(
                        Modifier.padding(it),
                        navController = navController
                    )
                }

            }

        }
    }

}