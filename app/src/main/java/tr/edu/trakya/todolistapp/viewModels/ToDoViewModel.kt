package tr.edu.trakya.todolistapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tr.edu.trakya.todolistapp.infrastructure.MainApplication
import tr.edu.trakya.todolistapp.model.Todo
import java.time.Instant
import java.util.Date

class ToDoViewModel  : ViewModel(){
    val todoDao  = MainApplication.toToDoDatabase.getTodoDao()
    private var _todoList = todoDao.getAllToDo()
    val todoList : LiveData<List<Todo>> = _todoList



    fun addItem (title :String){
        viewModelScope.launch  (Dispatchers.IO) {
            todoDao.add(Todo(id=0,title = title, createdAt = Date.from(Instant.now())))
        }

    }


    fun removeItem (id:Int){
        viewModelScope.launch (Dispatchers.IO){
            todoDao.delete(id)
        }

    }

    fun clear (){
        viewModelScope.launch (Dispatchers.IO){ todoDao.deleteAll()  }

    }

}