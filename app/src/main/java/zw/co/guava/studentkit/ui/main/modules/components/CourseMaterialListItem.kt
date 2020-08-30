package zw.co.guava.studentkit.ui.main.modules.components

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.EmphasisAmbient
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideEmphasis
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

@Composable
fun CourseMaterialListItem() {
    Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {

        Column(modifier = Modifier.weight(1f)) {
            Row {
                Column (modifier = Modifier.padding(4.dp).width(40.dp).gravity(Alignment.CenterVertically)) {
                    Icon(asset = Icons.Rounded.Settings)
                }

                Column (modifier = Modifier.padding(4.dp)){
                    Text(text = "Textbook for all", fontWeight = FontWeight.SemiBold)
                    ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                        Text(text = "Modified 2 days ago", style = MaterialTheme.typography.body2)
                    }
                }
            }
        }

        Column(modifier = Modifier.gravity(Alignment.CenterVertically)) {
            Icon(asset = Icons.Rounded.Done)

        }

    }
}

@Preview(showBackground = true)
@Composable
fun CourseMaterialListPreiew() {
    CourseMaterialListItem()
}