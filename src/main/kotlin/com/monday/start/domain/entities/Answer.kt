package com.monday.start.domain.entities

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonBackReference

@Entity
@Table(name = "answers")
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val answer: String? = null,
    val isCorrect: Boolean = false,

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    val question: Question? = null
)