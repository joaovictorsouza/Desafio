package br.eng.joaovictor.soluevo.domain.usecases.impl

import br.eng.joaovictor.soluevo.domain.model.WordCountItem
import br.eng.joaovictor.soluevo.domain.usecases.interfaces.CountWordUsecase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountWordUsecaseImpl @Inject constructor() : CountWordUsecase {
    override fun countWords(sentence: String): Flow<List<WordCountItem>> = flow {
        val regex = Regex("\\W+")
        val wordList = sentence.lowercase()
            .replace("\n", " ")
            .replace("\t", " ")
            .trim()
            .split(regex)
            .groupingBy { it }
            .eachCount()
            .map { WordCountItem(it.key, it.value) }

        emit(wordList)
    }
}