package eif.viko.lt.vo.musicplayer.presentation.ui.playlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
             itemTextColor: Color = Color(0xFFE0F7FA),
             onItemClick: (Track) -> Unit) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(item) }
                .padding(30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f)
                )
                //Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = item.artists[0].name,
                    modifier = Modifier.weight(1f)
                )

            }
            Divider()
        }
    }
}