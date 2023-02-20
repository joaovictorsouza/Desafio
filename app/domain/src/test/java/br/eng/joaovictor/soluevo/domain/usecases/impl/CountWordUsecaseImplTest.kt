package br.eng.joaovictor.soluevo.domain.usecases.impl

import br.eng.joaovictor.soluevo.domain.model.WordCountItem
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountWordUsecaseImplTest {

    @InjectMocks
    private lateinit var countWordUsecase: CountWordUsecaseImpl

    @Test
    fun `should return word list`() = runBlocking {
        val sentence = "this is a test"
        val expectedResult = listOf(
            WordCountItem("this", 1),
            WordCountItem("is", 1),
            WordCountItem("a", 1),
            WordCountItem("test", 1)
        )

        val flow = countWordUsecase.countWords(sentence)

        flow.collect { data ->
            assertEquals(expectedResult, data)
        }
    }
}
