package io.umsf.pimonovmykyta.testing

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "To-Do List") {
        InvalidApp()
    }
}

@Composable
private fun App() {
    var text by remember { mutableStateOf("Task17") }
    val tasks = remember { mutableStateListOf<String>() }
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var errorMessage by remember { mutableStateOf("") }

    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {

            Text("Введіть нову задачу:", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Купити молоко") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Button(onClick = {
                    if (text.isBlank()) {
                        errorMessage = "Задача не може бути порожньою!"
                    } else {
                        tasks.add(text.trim())
                        text = ""
                        errorMessage = ""
                    }
                }) {
                    Text("Додати")
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(onClick = {
                    if (selectedIndex == null || selectedIndex!! !in tasks.indices) {
                        errorMessage = "Оберіть задачу для видалення"
                    } else {
                        tasks.removeAt(selectedIndex!!)
                        selectedIndex = null
                        errorMessage = ""
                    }
                }) {
                    Text("Видалити")
                }
            }

            if (errorMessage.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(errorMessage, color = Color.Red)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Список задач:", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.height(8.dp))

            if (tasks.isEmpty()) {
                Text("Список порожній")
            } else {
                LazyColumn {
                    itemsIndexed(tasks) { index, task ->
                        val isSelected = index == selectedIndex

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(if (isSelected) Color.LightGray else Color.Transparent)
                                .clickable {
                                    selectedIndex = index
                                }
                                .padding(8.dp)
                        ) {
                            Text("${index + 1}. $task")
                        }
                    }
                }
            }
        }
    }
}
