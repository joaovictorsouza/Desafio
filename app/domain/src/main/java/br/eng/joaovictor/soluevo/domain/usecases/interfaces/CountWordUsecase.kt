package br.eng.joaovictor.soluevo.domain.usecases.interfaces

import br.eng.joaovictor.soluevo.domain.model.WordCountItem
import kotlinx.coroutines.flow.Flow

interface CountWordUsecase {
    fun countWords(sentence: String):  Flow<List<WordCountItem>>
}