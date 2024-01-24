package com.sofia.superHero.features.superHero.data.hero.local.room

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.data.hero.local.HeroLocalDataSource
import com.sofia.superHero.features.superHero.data.local.toEntity
import com.sofia.superHero.features.superHero.data.local.toModel
import com.sofia.superHero.features.superHero.domain.Hero
import javax.inject.Inject

class HeroLocalDbDataSource @Inject constructor(private val heroDao: HeroDao) : HeroLocalDataSource{
    override suspend fun findAllHeroes(): Either<ErrorApp, List<Hero>> {
        return try {
            val heroes = heroDao.getAll()
            if (heroes.isEmpty()) {
                listOf<Hero>().right()
            } else {
                heroes.map { heroEntity ->
                    heroEntity.toModel()
                }.right()
            }
        }catch (ex : Exception){
            ErrorApp.DataError.left()
        }
    }

    override suspend fun findHeroById(id: String): Either<ErrorApp, Hero> {
        return try {
            val hero = heroDao.getById(id)
            hero?.toModel()?.right() ?: ErrorApp.DataError.left()
        } catch (ex : Exception){
            ErrorApp.DataError.left()
        }
    }

    override suspend fun saveSuperHero(superHero: Hero): Either<ErrorApp, Boolean> {
        return try {
            heroDao.insert(superHero.toEntity())
            true.right()
        }catch (ex : Exception){
            ErrorApp.DataError.left()
        }
    }

}