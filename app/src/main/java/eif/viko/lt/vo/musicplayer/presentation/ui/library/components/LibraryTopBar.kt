package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eif.viko.lt.vo.musicplayer.R

@Composable
fun LibraryTopBar(
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth().padding(10.dp).height(50.dp),
        content = {
            Text(fontSize = 20.sp, text = stringResource(id = R.string.library_name))
        }
    )
}