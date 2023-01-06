package eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eif.viko.lt.vo.musicplayer.R

@Composable
fun PlaylistTopBar(
    name: String
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth().padding(10.dp).height(50.dp),
        content = {
            Text(text = name, fontSize = 20.sp)
        }
    )
}