package com.example.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipleroomtables.entities.Director
import com.example.multipleroomtables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
