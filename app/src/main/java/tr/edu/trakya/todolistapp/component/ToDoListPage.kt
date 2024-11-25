package tr.edu.trakya.todolistapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tr.edu.trakya.todolistapp.R
import tr.edu.trakya.todolistapp.model.Todo
import tr.edu.trakya.todolistapp.viewModels.ToDoViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ToDoListPage (viewModel: ToDoViewModel){
    val todoList by viewModel.todoList.observeAsState()
    var inputText  by remember{
        mutableStateOf("")
    }

    Column (modifier =
    Modifier
        .fillMaxHeight()
        .padding(8.dp)
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = inputText,
                onValueChange ={
                    inputText=it
                } , label = {
                    Text("New Item")
                }
            )
            IconButton(onClick = {
                viewModel.addItem(inputText)
                inputText=""
            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Add Button",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                    )
            }
            IconButton(onClick = {
                viewModel.clear()

            }) {
                Icon(painter = painterResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "Clear Button",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        todoList?.let {
            LazyColumn(content  = {
                itemsIndexed(it){ index: Int, item: Todo ->
                    ToDoItem(item = item, onDelete = {
                        viewModel.removeItem(item.id)
                    })
                }
            })
        }


    }
}

@Composable
fun ToDoItem (item : Todo,onDelete : ()->Unit){
    Row(modifier =
    Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.primary)
        .padding(16.dp)){
        Column (
            modifier = Modifier.weight(1f)
        )
        {
            Text(
                text = SimpleDateFormat("HH:mm:ss aa dd/MM", Locale.ENGLISH).format(item.createdAt),
                style = TextStyle(fontSize = 15.sp, color = Color.White)

            )
            Text(text = item.title,style = TextStyle(fontSize = 20.sp, color = Color.White))
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription ="delete_button",
                tint = Color.White
            )
        }
    }

}