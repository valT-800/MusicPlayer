package eif.viko.lt.vo.musicplayer.presentation.ui.components.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ProgressBar() {
    Box(modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}