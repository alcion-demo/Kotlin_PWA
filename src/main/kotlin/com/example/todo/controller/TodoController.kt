package com.example.todo.controller

import com.example.todo.entity.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.time.ZoneId

@Controller
class TodoController(private val todoRepository: TodoRepository) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("todos", todoRepository.findAll())
        return "todo/index"
    }

    @PostMapping("/add")
    fun addTodo(@RequestParam title: String): String {
        todoRepository.save(Todo(title = title))
        return "redirect:/"
    }

    @PostMapping("/toggle/{id}")
    fun toggle(@PathVariable id: Long): String {
        val todo: Todo? = todoRepository.findById(id).orElse(null)
        todo?.let {
            it.completed = !it.completed
            it.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"))
            todoRepository.save(it)
        }
        return "redirect:/"
    }

    @PostMapping("/delete/{id}")
    fun delete(@PathVariable id: Long): String {
        todoRepository.deleteById(id)
        return "redirect:/"
    }

    @PostMapping("/edit/{id}")
    fun edit(@PathVariable id: Long, @RequestParam title: String): String {
        val todo: Todo? = todoRepository.findById(id).orElse(null)
        todo?.let {
            it.title = title
            it.updatedAt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"))
            todoRepository.save(it)
        }
        return "redirect:/"
    }
}
