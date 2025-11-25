package com.example.todo.service

import com.example.todo.repository.TodoRepository
import com.example.todo.entity.Todo
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val repository: TodoRepository
) {
    fun list(): List<Todo> = repository.findAll()

    fun add(title: String) = repository.save(Todo(title = title))
}
