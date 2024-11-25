package tr.edu.trakya.todolistapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import tr.edu.trakya.todolistapp.model.Todo

@Dao
interface ToDoDao {

    @Query("Select * from todo")
    fun getAllToDo() : LiveData<List<Todo>>

    @Insert
    fun add(item : Todo)

    @Query("delete from Todo where id= :id")
    fun delete (id : Int)

    @Query("delete from Todo")
    fun deleteAll ()

}