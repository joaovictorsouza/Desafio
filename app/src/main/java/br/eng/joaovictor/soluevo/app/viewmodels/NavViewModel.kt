package br.eng.joaovictor.soluevo.app.viewmodels

import androidx.lifecycle.ViewModel
import br.eng.joaovictor.soluevo.app.utils.NavigationService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(
    navigationService: NavigationService,
): ViewModel() {
    val controller = navigationService.navController
}