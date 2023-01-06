package eif.viko.lt.vo.musicplayer.presentation.ui.components.icons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import eif.viko.lt.vo.musicplayer.R

@Composable
fun PauseIcon (
    onClick: () -> Unit,
    size: DpSize
){
    IconButton(modifier = Modifier.size(size),onClick = onClick) {
        Icon(
            painter = painterResource(id = R.drawable.ic_pause),
            contentDescription = "",
            Modifier.size(50.dp)
        )
    }
}