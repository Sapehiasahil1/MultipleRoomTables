package com.example.multipleroomtables

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.multipleroomtables.entities.Director
import com.example.multipleroomtables.entities.School
import com.example.multipleroomtables.entities.Student
import com.example.multipleroomtables.entities.relations.SchoolAndDirector
import com.example.multipleroomtables.entities.relations.SchoolWithStudents

@Dao
interface SchoolDao {

    // One to One
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction // It is done to execute the function in thread-safe manner.
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName : String) : List<SchoolAndDirector>

    //One to Many
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>
}