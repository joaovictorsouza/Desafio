package br.eng.joaovictor.soluevo.app.di

import br.eng.joaovictor.soluevo.app.DesafioApplication
import br.eng.joaovictor.soluevo.domain.di.DomainComponent
import dagger.Component

@Component(dependencies = [DomainComponent::class])
interface AppComponent {
    fun inject(app: DesafioApplication)
}