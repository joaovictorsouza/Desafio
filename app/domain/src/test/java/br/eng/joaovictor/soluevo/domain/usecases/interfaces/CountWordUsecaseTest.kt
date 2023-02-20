package br.eng.joaovictor.soluevo.domain.usecases.interfaces

import org.junit.Assert.assertEquals
import org.junit.Test
import br.eng.joaovictor.soluevo.domain.model.WordCountItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class CountWordUsecaseTest {

    private val countWordUsecase = object : CountWordUsecase {
        override fun countWords(sentence: String): Flow<List<WordCountItem>> {
            return flow {
                val wordList = sentence.split(" ")
                    .groupBy { it }
                    .map { WordCountItem(it.key, it.value.count()) }
                emit(wordList)
            }
        }
    }

    @Test
    fun `count words test`() = runBlocking {
        val sentence = "word1 word2 word3 word1"
        val expectedResult = listOf(
            WordCountItem("word1", 2),
            WordCountItem("word2", 1),
            WordCountItem("word3", 1)
        )

        val flow = countWordUsecase.countWords(sentence)

        flow.collect { data ->
            assertEquals(expectedResult, data)
        }
    }
}
