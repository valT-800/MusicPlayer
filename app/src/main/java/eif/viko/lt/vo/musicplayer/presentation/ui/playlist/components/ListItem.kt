package eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eif.viko.lt.vo.musicplayer.R
import eif.viko.lt.vo.musicplayer.domain.model.Track


@Composable
fun ListItem(modifier: Modifier = Modifier,
             items: List<Track>,
             itemTextStyle: TextStyle = TextStyle(fontSize = 15.sp),
             itemTextColor: Color = Color(0xFFBAD9E7),
             onItemClick: (Track) -> Unit) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
                .padding(30.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "",
                modifier = Modifier.size(30.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column (Modifier.fillMaxSize()){
                    Text(
                        text = item.name,
                        style = itemTextStyle,
                        color = itemTextColor,
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        text = item.artist.name,
                        style = itemTextStyle,
                        color = itemTextColor,
                        modifier = Modifier.weight(1f)
                        )
                }

            }
            Divider()
        }
    }
}