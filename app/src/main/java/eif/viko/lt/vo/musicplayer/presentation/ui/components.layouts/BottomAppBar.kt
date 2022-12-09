package eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.domain.util.Route

@Composable
fun BottomBar(

){
    BottomAppBar(
        modifier = Modifier.padding(20.dp),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.primary,
        cutoutShape = MaterialTheme.shapes.large,
        elevation = 50.dp,
        content = {

        },
    )

}