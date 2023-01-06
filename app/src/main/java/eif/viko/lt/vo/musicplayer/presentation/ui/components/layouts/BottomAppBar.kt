package eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.domain.util.Route
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.HomeIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.LibraryIcon
import eif.viko.lt.vo.musicplayer.presentation.ui.components.icons.SearchIcon


@Composable
fun BottomBar(
    navController: NavController
){

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(10.dp),
        //backgroundColor = MaterialTheme.colors.primary,
        //contentColor = MaterialTheme.colors.primary,
        //cutoutShape = MaterialTheme.shapes.large,
        elevation = 2.dp,
    ){
        Row (
            Modifier.fillMaxWidth().padding(2.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            SearchIcon(size = DpSize(50.dp, 50.dp), onClick = { navController.navigate(Route.SEARCH_SCREEN) })
            HomeIcon(size = DpSize(50.dp, 50.dp), onClick = { navController.navigate(Route.HOME_SCREEN) })
            LibraryIcon(size = DpSize(50.dp, 50.dp), onClick = { navController.navigate(Route.LIBRARY_SCREEN) })

        }


    }

}