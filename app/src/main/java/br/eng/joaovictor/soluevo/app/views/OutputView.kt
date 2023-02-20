@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package br.eng.joaovictor.soluevo.app.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import br.eng.joaovictor.soluevo.app.R
import br.eng.joaovictor.soluevo.app.composables.DesafioTopBar
import br.eng.joaovictor.soluevo.app.composables.WordItem
import br.eng.joaovictor.soluevo.app.ui.theme.DesafioSoluevoTheme
import br.eng.joaovictor.soluevo.app.viewmodels.InputViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OutputView(modifier: Modifier = Modifier, viewModel: InputViewModel, navController: NavHostController) {
    val sentence by viewModel.sentence.collectAsStateWithLifecycle()
    val wordList by viewModel.wordList.collectAsStateWithLifecycle()

    Scaffold(topBar = { DesafioTopBar(navController = navController) }) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues = paddingValues)) {
//            OutlinedCard(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth()
//            ) {
//                Column(Modifier.padding(16.dp)) {
//                    Text(text = stringResource(R.string.frase_inserida), style = MaterialTheme.typography.titleMedium)
//                    Text(text = sentence, style = MaterialTheme.typography.bodyLarge)
//                }
//            }
            OutlinedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(R.string.ocorr_ncia_de_palavras),
                        style = MaterialTheme.typography.titleMedium
                    )
                    LazyVerticalGrid(
                        modifier = Modifier.padding(vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        columns = GridCells.Fixed(2),
                        content = {
                        this.items(items = wordList) { item ->
                            WordItem(item = item)
                        }
                    })
                }
            }
        }
    }
}

