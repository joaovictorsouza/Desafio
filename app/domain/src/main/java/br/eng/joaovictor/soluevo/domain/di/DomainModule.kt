package br.eng.joaovictor.soluevo.domain.di

import br.eng.joaovictor.soluevo.domain.usecases.impl.CountWordUsecaseImpl
import br.eng.joaovictor.soluevo.domain.usecases.interfaces.CountWordUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton


@Module
@InstallIn(DomainComponent::class)
class DomainModule {

    @Singleton
    @Provides
    fun provideCountWordUseCase(): CountWordUsecase {
        return CountWordUsecaseImpl()
    }
}