package eif.viko.lt.vo.musicplayer.presentation.ui.library.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eif.viko.lt.vo.musicplayer.R

@Composable
fun FavoritesCard(
    onItemClick: () -> Unit

) {
    Card (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick() }
            .height(80.dp),
        elevation = 3.dp

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = Modifier.fillMaxHeight().padding(5.dp)){
                Icon( painter = painterResource(id = R.drawable.ic_favorite_border), contentDescription = "favorite")
            }
            Text(fontSize = 20.sp, text = stringResource(id = R.string.favorites_name))

        }
    }
}