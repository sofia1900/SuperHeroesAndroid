package com.sofia.superHero.features.superHero.data.hero.local.sharedPreferences

import android.content.Context
import com.sofia.superHero.app.data.serialization.JsonSerialization
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.data.hero.local.HeroLocalDataSource
import com.sofia.superHero.features.superHero.domain.Hero
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HeroLocalSharedPreferencesDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: JsonSerialization
) : HeroLocalDataSource {

    private val sharedPref = context.getSharedPreferences("heroes", Context.MODE_PRIVATE)

    override suspend fun findAllHeroes(): Either<ErrorApp, List<Hero>> {
        return try {
            val heroesMap = sharedPref.all as Map<String, String>
            heroesMap.values.map {
                json.fromJson(it, Hero::class.java)
            }.right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }

    override suspend fun findHeroById(id: String): Either<ErrorApp, Hero> {
        return try {
            val jsonHero = sharedPref.getString(id, "{}")!!
            json.fromJson(jsonHero, Hero::class.java).right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }

    override suspend fun saveSuperHero(superHero: Hero): Either<ErrorApp, Boolean> {
        return try {
            with(sharedPref.edit()) {
                val jsonSuperHero = json.toJson(superHero, Hero::class.java)
                putString(superHero.id, jsonSuperHero)
                apply()
            }
            true.right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }
}