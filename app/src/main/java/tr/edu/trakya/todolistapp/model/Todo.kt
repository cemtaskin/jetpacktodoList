package tr.edu.trakya.todolistapp.model

import androidx.compose.runtime.saveable.autoSaver
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar
import java.util.Date
import javax.annotation.processing.Generated

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var createdAt : Date
)


