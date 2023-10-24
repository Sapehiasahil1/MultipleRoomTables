package com.example.multipleroomtables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.multipleroomtables.entities.Director
import com.example.multipleroomtables.entities.School

data class SchoolAndDirector(
    // The Embedded annotation assures that the school entities fields are inserted in the SchoolAndDirector class.
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", // It refers to the parentColumn (in this case its School Entity)
        entityColumn = "schoolName" // This column is not the primary key but it is compared to the column that is the primary key
    )
    val director: Director
)
