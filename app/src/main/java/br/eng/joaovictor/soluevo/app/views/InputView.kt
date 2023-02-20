@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class,
    ExperimentalMaterial3Api::class
)

package br.eng.joaovictor.soluevo.app.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.eng.joaovictor.soluevo.app.R
import br.eng.joaovictor.soluevo.app.composables.DesafioTopBar
import br.eng.joaovictor.soluevo.app.utils.Step
import br.eng.joaovictor.soluevo.app.viewmodels.InputViewModel

@Composable
fun InputView(modifier: Modifier = Modifier, viewModel: InputViewModel, navController: NavHostController) {
    val sentence by viewModel.sentence.collectAsStateWithLifecycle()
    val focusRequester by viewModel.focusRequester.collectAsStateWithLifecycle()
    val textSize = TextUnit(value = 30f, type = TextUnitType.Sp)


    LaunchedEffect(Unit) {
        viewModel.setTextFieldFocus()
    }

    Scaffold(topBar = { DesafioTopBar(navController = navController) }) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .focusRequester(focusRequester = focusRequester),
                label = { Text(text = stringResource(R.string.digite_uma_frase)) },
                value = sentence,
                onValueChange =  { viewModel.setSentence(it) },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent,
                ),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = textSize)
                    )
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                onClick = {
                    viewModel.countWords()
                }) {
                Text(text = stringResource(R.string.mostrar_repeticao),)
            }
        }
    }
}