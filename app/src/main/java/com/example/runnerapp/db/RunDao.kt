package com.example.runnerapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("select * from running_table order by timeStamp desc")
    fun getAllRunSortedByDate(): LiveData<List<Run>>

    @Query("select * from running_table order by timeInMillis desc")
    fun getAllRunSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("select * from running_table order by caloriesBurned desc")
    fun getAllRunSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("select * from running_table order by avgSpeedInKMH desc")
    fun getAllRunSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("select * from running_table order by distanceMeters desc")
    fun getAllRunSortedByDistance(): LiveData<List<Run>>

    @Query("select sum(timeInMillis) from running_table")
    fun getTotalTimeInMillis(): LiveData<Long>

    @Query("select sum(caloriesBurned) from running_table")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("select sum(distanceMeters) from running_table")
    fun getTotalDistance(): LiveData<Int>

    @Query("select avg(avgSpeedInKMH) from running_table")
    fun getTotalAvgSpeed(): LiveData<Float>
}
