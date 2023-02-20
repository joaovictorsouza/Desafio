package br.eng.joaovictor.soluevo.domain.di

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface DomainComponent {
}