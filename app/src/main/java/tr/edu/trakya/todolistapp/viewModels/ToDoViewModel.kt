package tr.edu.trakya.todolistapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tr.edu.trakya.todolistapp.model.ToDoManager
import tr.edu.trakya.todolistapp.model.Todo

class ToDoViewModel  : ViewModel(){
    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    fun getAll () {
        _todoList.value= ToDoManager.getAllToDo()
    }

    fun addItem (title :String){
        ToDoManager.addToDo(title)
        getAll()
    }


    fun removeItem (id:Int){
        ToDoManager.remove(id)
        getAll()
    }

    fun clear (){
        ToDoManager.clear()
        getAll()
    }

}