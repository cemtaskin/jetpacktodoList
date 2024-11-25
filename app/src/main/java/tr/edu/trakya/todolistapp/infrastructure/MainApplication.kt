package tr.edu.trakya.todolistapp.infrastructure

import android.app.Application
import androidx.room.Room
import tr.edu.trakya.todolistapp.db.ToDoDatabase

class MainApplication : Application() {
    companion object{
        lateinit var toToDoDatabase: ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        toToDoDatabase =  Room.databaseBuilder(applicationContext,
            ToDoDatabase::class.java,
            ToDoDatabase.NAME)
            .build()
    }

}