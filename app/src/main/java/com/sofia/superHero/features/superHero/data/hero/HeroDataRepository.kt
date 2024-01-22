package com.sofia.superHero.features.superHero.data.hero

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.hero.local.HeroLocalDataSource
import com.sofia.superHero.features.superHero.data.hero.remote.HeroApiRemoteDataSource
import com.sofia.superHero.features.superHero.domain.Hero
import com.sofia.superHero.features.superHero.domain.HeroRepository
import javax.inject.Inject

class HeroDataRepository @Inject constructor(
    private val localData: HeroLocalDataSource,
    private val remoteApiData: HeroApiRemoteDataSource
) : HeroRepository {
    override suspend fun findHeroes(): Either<ErrorApp, List<Hero>> {
        val local = localData.findAllHeroes()
        return if (local.isRight() && local.get().isNotEmpty()) local
        else {
            remoteApiData.findAllSuperHeroes().map { heroes ->
                for (hero in remoteApiData.findAllSuperHeroes().get()) {
                    localData.saveSuperHero(hero)
                }
                heroes
            }
        }
    }

    override suspend fun findHeroById(id: String): Either<ErrorApp, Hero> {
        val heroLocal = localData.findHeroById(id)
        return if (heroLocal.isRight() && heroLocal.get().id != null) heroLocal
        else {
            return remoteApiData.findHeroById(id).map { hero ->
                localData.saveSuperHero(hero)
                hero
            }
        }
    }
}