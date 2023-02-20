@file:OptIn(ExperimentalMaterial3Api::class)
package br.eng.joaovictor.soluevo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.eng.joaovictor.soluevo.app.ui.theme.DesafioSoluevoTheme
import br.eng.joaovictor.soluevo.app.viewmodels.InputViewModel
import br.eng.joaovictor.soluevo.app.viewmodels.NavViewModel
import br.eng.joaovictor.soluevo.app.views.InputView
import br.eng.joaovictor.soluevo.app.views.OutputView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: InputViewModel = viewModel()
            val navViewModel: NavViewModel = viewModel()

            DesafioSoluevoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navViewModel.controller, startDestination = "input") {
                        composable("input") { InputView(viewModel = viewModel, navController = navViewModel.controller) }
                        composable("output") { OutputView(viewModel = viewModel, navController = navViewModel.controller) }
                    }
                }
            }
        }
    }
}