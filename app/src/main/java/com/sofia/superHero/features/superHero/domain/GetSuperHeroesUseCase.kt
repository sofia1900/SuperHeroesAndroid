package com.sofia.superHero.features.superHero.domain


import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import javax.inject.Inject

class GetSuperHeroesUseCase @Inject constructor(
    private val heroRepository: HeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {
    suspend operator fun invoke(): Either<ErrorApp, List<SuperHero>> {
        val superHeroes = mutableListOf<SuperHero>()

        return heroRepository.findHeroes().map { heroes ->
            for (superHero in heroes) {
                val biography = biographyRepository.getBiography(superHero.id).mapLeft {
                    return ErrorApp.DataError.left()
                }

                val work = workRepository.getWork(superHero.id).mapLeft {
                    return ErrorApp.DataError.left()
                }

                superHeroes.add(
                    SuperHero(
                        superHero.id,
                        superHero.name,
                        biography.get().fullName,
                        work.get().occupation,
                        superHero.image,
                        biography.get().alignment,
                        superHero.intelligence,
                        superHero.strength,
                        superHero.speed,
                        superHero.durability,
                        superHero.power,
                        superHero.combat
                    )
                )
            }
            superHeroes
        }
    }
}