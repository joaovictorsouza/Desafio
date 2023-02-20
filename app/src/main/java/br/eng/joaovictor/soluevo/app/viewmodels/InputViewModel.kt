package br.eng.joaovictor.soluevo.app.viewmodels

import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.eng.joaovictor.soluevo.app.utils.NavigationService
import br.eng.joaovictor.soluevo.app.utils.Step
import br.eng.joaovictor.soluevo.domain.model.WordCountItem
import br.eng.joaovictor.soluevo.domain.usecases.impl.CountWordUsecaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(private val countWordUsecase: CountWordUsecaseImpl,
                                         private val navigationService: NavigationService
): ViewModel() {

    private val _sentence = MutableStateFlow("")
    val sentence = _sentence.asStateFlow()

    private val _wordList = MutableStateFlow(listOf<WordCountItem>())
    val wordList = _wordList.asStateFlow()

    private val _focusRequester = MutableStateFlow(FocusRequester())
    val focusRequester: StateFlow<FocusRequester> = _focusRequester

    fun setTextFieldFocus(focus: Boolean = true) {
        if(focus) _focusRequester.value.requestFocus() else
            _focusRequester.value.freeFocus()
    }

    fun setSentence(sentence: String) {
        _sentence.value = sentence
    }

    fun countWords(){
        navigationService.navController.navigate(route = "Output")
        viewModelScope.launch {
           countWordUsecase.countWords(sentence.value)
               .collect { wordList ->
                   _wordList.value = wordList
               }
        }
    }
}

