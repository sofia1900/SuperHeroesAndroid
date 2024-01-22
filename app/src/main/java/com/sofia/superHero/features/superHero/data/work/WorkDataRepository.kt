package com.sofia.superHero.features.superHero.data.work

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.features.superHero.data.work.local.WorkLocalDataSource
import com.sofia.superHero.features.superHero.data.work.remote.WorkApiRemoteDataSource
import com.sofia.superHero.features.superHero.domain.Work
import com.sofia.superHero.features.superHero.domain.WorkRepository
import javax.inject.Inject

class WorkDataRepository @Inject constructor(
    private val localData: WorkLocalDataSource,
    private val remoteApiData: WorkApiRemoteDataSource
) : WorkRepository {
    override suspend fun getWork(id: String): Either<ErrorApp, Work> {
        val local = localData.findWorkById(id)
        return if (local.isRight() && local.get().id != null) local
        else {
            remoteApiData.getOccupation(id).map { work ->
                localData.saveWork(work)
                work
            }
        }
    }
}