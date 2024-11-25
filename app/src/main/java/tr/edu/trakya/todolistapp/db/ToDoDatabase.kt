package tr.edu.trakya.todolistapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tr.edu.trakya.todolistapp.model.Todo

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class ToDoDatabase: RoomDatabase() {
    companion object {
        const val NAME= "todo_db"
    }

    abstract fun getTodoDao() : ToDoDao
}