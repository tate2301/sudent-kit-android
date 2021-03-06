package zw.co.guava.studentkit.ui.main.transport.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import zw.co.guava.studentkit.ui.composeTheme.gray
import zw.co.guava.studentkit.ui.composeTheme.lightText
import zw.co.guava.studentkit.ui.composeTheme.text


@Composable
fun TripCard() {

    val (cardExpanded, setCardExpanded) = remember { mutableStateOf(false) }
    val wayPoints = remember { mutableStateOf(listOf<RouteStops>(RouteStops(name = "Coldstream Hospital", time = 8883893), RouteStops(name = "PaRoma Bus Stop", time = 8883893))) }
    Column {

        Row (modifier = Modifier.padding(horizontal = 4.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Column(modifier = Modifier.gravity(Alignment.CenterVertically)) {
                    ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                        Row {
                            Text(text = "DEPARTING BUS", modifier = Modifier.padding(start=4.dp, end=4.dp), fontWeight = FontWeight(500), style = MaterialTheme.typography.body2)
                            Text(text = "・", fontWeight = FontWeight(600))
                            Text(text = "14:15", modifier = Modifier.padding(start=4.dp, end=4.dp), fontWeight = FontWeight(500), style = MaterialTheme.typography.body2)
                        }
                    }
                }

                Column {
                    when (cardExpanded) {
                        false -> {
                            IconButton(
                                onClick = {setCardExpanded(!cardExpanded)}) {
                                Icon(asset = Icons.Rounded.KeyboardArrowDown, tint = gray)
                            }
                        }

                        true -> {
                            IconButton(
                                onClick = {setCardExpanded(!cardExpanded)}) {
                                Icon(asset = Icons.Rounded.KeyboardArrowUp, tint = gray)
                            }
                        }
                    }
                }
            }
            Divider(thickness = 0.5.dp)

            when(cardExpanded) {
                false -> {
                    TripCardDefault()
                }

                true -> {
                    TripCardExpanded(wayPoints = wayPoints.value)
                }
            }
        }
    Spacer(modifier = Modifier.padding(4.dp))
    Divider(thickness = 1.dp)
}

@Composable
fun TripCardDefault() {
    Row (modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
        Column {
            Text(text = "14:15", style = MaterialTheme.typography.h1, modifier = Modifier.padding(start=4.dp, end=4.dp))
            Text(text = "Campus", style = MaterialTheme.typography.body2, textAlign = TextAlign.End)
        }

        Column {
            Text(text = "15:00", style = MaterialTheme.typography.h1, textAlign = TextAlign.End, modifier = Modifier.padding(start=4.dp, end=4.dp).fillMaxWidth())
            Text(text = "Mzari", style = MaterialTheme.typography.body2, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
        }
    }
    Row(modifier = Modifier.padding(horizontal = 16.dp,  vertical = 4.dp)) {
        ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
            Text(text = "4 stops along the way")
            Text(text = "・")
            Text(text = "0 h 45 m ")
        }

    }
}

@Composable
fun TripCardExpanded(wayPoints: List<RouteStops>) {
    LazyColumnFor(items = wayPoints) {
        Spacer(modifier = Modifier.padding(8.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Column() {
                Icon(asset = Icons.Outlined.Info, tint = gray)
            }
            Spacer(modifier = Modifier.padding(8.dp))
            
            Column(modifier = Modifier.padding(start = 8.dp).gravity(Alignment.CenterVertically)) {
                Text(text = "15:40", style = MaterialTheme.typography.h1, fontWeight = FontWeight(600))
                Text(text = it.name)
                Text(text = it.time.toString(), style = MaterialTheme.typography.body2)
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))

    }
}