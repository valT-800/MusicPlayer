package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import eif.viko.lt.vo.musicplayer.R
import kotlinx.coroutines.job

@Composable
fun AddPlaylistAlertDialog (
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPlaylist: (name: String) -> Unit
){
    if(openDialog){
        var name by remember { mutableStateOf(" ")}

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(id = R.string.add_playlist_name))
            },
            text = {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.playlist_name),
                            //color = Color.White
                        )
                    },
                    modifier = Modifier.height(16.dp)
                )
                /*LaunchedEffect(Unit) {
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }*/

            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        addPlaylist(name)
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.add)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(
                        text = stringResource(id = R.string.close)
                    )
                }
            }
        )
    }
}