package com.example.roomcronoapp.repository

import com.example.roomcronoapp.model.Cronos
import com.example.roomcronoapp.room.CronosDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronosRepository @Inject constructor(private val cronosDatabaseDao: CronosDatabaseDao) {

    suspend fun addCrono(cronos: Cronos) = cronosDatabaseDao.insert(cronos)
    suspend fun updateCrono(cronos: Cronos) = cronosDatabaseDao.update(cronos)
    suspend fun delete(cronos: Cronos) = cronosDatabaseDao.delete(cronos)
    fun getAllCronos(): Flow<List<Cronos>> =
        cronosDatabaseDao.getCronos().flowOn(Dispatchers.IO).conflate()

    fun getCronoById(id: Long): Flow<Cronos> =
        cronosDatabaseDao.getCronosById(id).flowOn(Dispatchers.IO).conflate()
}