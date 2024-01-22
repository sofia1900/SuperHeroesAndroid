package com.sofia.superHero.features.superHero.domain

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import javax.inject.Inject

class GetSuperHeroByIdUseCase @Inject constructor(
    private val heroRepository: HeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {
    suspend operator fun invoke (id : String) : Either<ErrorApp, SuperHero> {

        if (heroRepository.findHeroById(id).isRight()){

            val hero = heroRepository.findHeroById(id).get()

            val work = workRepository.getWork(id).mapLeft {
                return ErrorApp.DataError.left()
            }
            val biography = biographyRepository.getBiography(id).mapLeft {
                return ErrorApp.DataError.left()
            }

            return SuperHero(hero.id, hero.name, biography.get().fullName, work.get().occupation, hero.image,
                biography.get().alignment, hero.intelligence, hero.strength, hero.speed, hero.durability,
                hero.power, hero.combat).right()

        }else{
            return ErrorApp.DataError.left()
        }
    }
}