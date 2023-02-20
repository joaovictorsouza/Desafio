@file:OptIn(ExperimentalMaterial3Api::class)

package br.eng.joaovictor.soluevo.app.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import br.eng.joaovictor.soluevo.app.R

@Composable
fun DesafioTopBar(modifier: Modifier = Modifier, navController: NavHostController) {
    CenterAlignedTopAppBar(title = { Text(text = "Desafio Soluevo")},
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = stringResource(R.string.voltar))
                }
            }
        }
    )
}