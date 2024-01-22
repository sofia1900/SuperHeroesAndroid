package com.sofia.superHero.features.superHero.data.work.local

import android.content.Context
import com.sofia.superHero.app.data.serialization.JsonSerialization
import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import com.sofia.superHero.features.superHero.domain.Work
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WorkLocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: JsonSerialization
) {
    private val sharedPref = context.getSharedPreferences("work", Context.MODE_PRIVATE)

    fun findWorkById(id: String): Either<ErrorApp, Work> {
        return try {
            val jsonWork = sharedPref.getString(id, "{}")!!
            json.fromJson(jsonWork, Work::class.java).right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }

    fun saveWork(work: Work): Either<ErrorApp, Boolean> {
        return try {
            with(sharedPref.edit()) {
                val jsonWork = json.toJson(work, Work::class.java)
                putString(work.id, jsonWork)
                apply()
            }
            true.right()
        } catch (ex: Exception) {
            return ErrorApp.DataError.left()
        }
    }
}