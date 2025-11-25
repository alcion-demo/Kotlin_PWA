package com.example.todo.entity

import jakarta.persistence.*
import java.time.LocalDateTime
import java.time.ZoneId

@Entity
class Todo() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var title: String = ""
    var completed: Boolean = false
    var createdAt: LocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"))
    var updatedAt: LocalDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"))

    constructor(title: String) : this() {
        this.title = title
    }
}
