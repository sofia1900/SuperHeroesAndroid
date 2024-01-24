package com.sofia.superHero.features.superHero.data.biography.local.sharedPreferences

import android.content.Context
import com.sofia.superHero.app.data.serialization.JsonSerialization
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.data.biography.local.BiographyLocalDataSource
import com.sofia.superHero.features.superHero.domain.Biography
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BiographyLocalSharedPreferencesDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: JsonSerialization
) : BiographyLocalDataSource{

    private val sharedPref = context.getSharedPreferences("biography", Context.MODE_PRIVATE)

    override suspend fun findBiographyById(id: String): Either<ErrorApp, Biography> {
        return try {
            val jsonBiography = sharedPref.getString(id, "{}")
            json.fromJson(jsonBiography!!, Biography::class.java).right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }

    override suspend fun saveBiography(biography: Biography): Either<ErrorApp, Boolean> {
        return try {
            with(sharedPref.edit()) {
                val jsonBiography = json.toJson(biography, Biography::class.java)
                putString(biography.id, jsonBiography)
                apply()
            }
            true.right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }

}