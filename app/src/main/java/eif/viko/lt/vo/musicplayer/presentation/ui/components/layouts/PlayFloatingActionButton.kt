package eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.presentation.ui.theme.Purple200

@Composable
fun PlayFloatingActionButton (
    onClick: () -> Unit
){
    FloatingActionButton(onClick = onClick, backgroundColor = Purple200) {
        Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play")
    }
}