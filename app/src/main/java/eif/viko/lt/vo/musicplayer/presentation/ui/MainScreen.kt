package eif.viko.lt.vo.musicplayer.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import eif.viko.lt.vo.musicplayer.presentation.navigation.MyAppNavHost
import eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts.BottomBar
import eif.viko.lt.vo.musicplayer.presentation.ui.player.PlayerView
import eif.viko.lt.vo.musicplayer.presentation.ui.player.PlayerViewModel
import eif.viko.lt.vo.musicplayer.presentation.ui.player.components.*
import eif.viko.lt.vo.musicplayer.presentation.ui.theme.MusicPlayerTheme


@Composable
fun MainScreen(
    viewModel: PlayerViewModel = hiltViewModel()
) {
    MusicPlayerTheme {

        val navController = rememberNavController()
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {

            },

            bottomBar = {
                Column(

                ) {

                    PlayerView(
                        navController = navController,
                        showPlayer = viewModel.showPlayer,
                        playNextTrack = { viewModel.playNextTrack() },
                        play = { viewModel.play() },
                        track = viewModel.selectedTrack,
                        playerState = viewModel.playerState,
                        playPreviousTrack = { viewModel.playPreviousTrack() }

                    )
                    BottomBar(
                        navController = navController
                    )
                }


            }
        ) {
            Player()

            MyAppNavHost(
                Modifier.padding(it),
                navController = navController,
                showPlayer = {viewModel.showPlayer()},
                playSelectedTrack = {index, track -> viewModel.playSelectedTrack(index, track)},
                initializePlayer = { tracks ->  viewModel.initializePlayer(tracks)}
            )




        }
        PlaySelectedTrack()
        Play()
        PlayPreviousTrack()
        PlayNextTrack()

    }

}