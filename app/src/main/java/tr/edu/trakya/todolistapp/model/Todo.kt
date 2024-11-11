package tr.edu.trakya.todolistapp.model

import java.util.Calendar
import java.util.Date

data class Todo(
    var id : Int,
    var title : String,
    var createdAt : Date
)

fun getDummyData () : List<Todo>{
    return listOf<Todo>(
        Todo(id = 1, title = "Play football", createdAt = Calendar.getInstance().time),
        Todo(id = 2, title = "Read book", createdAt = Calendar.getInstance().time),
        Todo(id = 3, title = "Study course", createdAt = Calendar.getInstance().time),Todo(id = 1, title = "Play football", createdAt = Calendar.getInstance().time),
        Todo(id = 4, title = "Eat food", createdAt = Calendar.getInstance().time)
    )
}