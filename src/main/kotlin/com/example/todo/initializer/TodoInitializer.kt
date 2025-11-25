package com.example.todo

import com.example.todo.entity.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TodoInitializer(private val todoRepository: TodoRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        // データベースに既存データがなければ初期データを作成
        if (todoRepository.count() == 0L) {
            val todos = listOf(
                Todo(title = "最初の Todo 1"),
                Todo(title = "最初の Todo 2"),
                Todo(title = "最初の Todo 3")
            )
            todoRepository.saveAll(todos)
            println("初期データを作成しました")
        }
    }
}
