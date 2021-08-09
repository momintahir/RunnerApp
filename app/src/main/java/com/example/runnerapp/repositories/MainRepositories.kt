package com.example.runnerapp.repositories

import com.example.runnerapp.db.Run
import com.example.runnerapp.db.RunDao
import javax.inject.Inject

class MainRepositories @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)
    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)
    fun getAllRunSortedByDate() = runDao.getAllRunSortedByDate()
    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunSortedByTimeInMillis()
    fun getAllRunSortedByCaloriesBurned() = runDao.getAllRunSortedByCaloriesBurned()
    fun getAllRunSortedByAvgSpeed() = runDao.getAllRunSortedByAvgSpeed()
    fun getAllRunSortedByDistance() = runDao.getAllRunSortedByDistance()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()
}