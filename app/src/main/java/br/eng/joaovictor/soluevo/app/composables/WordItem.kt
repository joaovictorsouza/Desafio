@file:OptIn(ExperimentalMaterial3Api::class)

package br.eng.joaovictor.soluevo.app.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.eng.joaovictor.soluevo.domain.model.WordCountItem

@Composable
fun WordItem(item: WordCountItem) {
    Card() {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = item.word, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f))
           Box(modifier = Modifier.fillMaxHeight().fillMaxWidth()
               .background(color = Color.Gray), contentAlignment = Alignment.Center){
               Text(text = item.count.toString())
           }

        }
    }
}