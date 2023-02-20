package br.eng.joaovictor.soluevo.app.utils

sealed class Step{
    object Input : Step()
    object Output : Step()
}
