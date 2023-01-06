package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import eif.viko.lt.vo.musicplayer.presentation.ui.theme.Purple200


@Composable
fun AddPlaylistFloatingActionButton (
    openDialog: () -> Unit
){
    FloatingActionButton(onClick = openDialog, backgroundColor = Purple200) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}