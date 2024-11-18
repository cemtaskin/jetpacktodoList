package tr.edu.trakya.todolistapp.model

import java.time.Instant
import java.util.Calendar
import java.util.Date

object ToDoManager {
    private val toDoList= mutableListOf<Todo>()

    fun getAllToDo () : List<Todo>{
        return toDoList;
    }

    fun addToDo (title : String){
        toDoList.add(Todo(toDoList.size,title, Calendar.getInstance().time))
    }

    fun remove (id : Int){
        toDoList.removeIf({
            it.id == id
        })
    }

    fun clear (){
        toDoList.clear()
    }

}