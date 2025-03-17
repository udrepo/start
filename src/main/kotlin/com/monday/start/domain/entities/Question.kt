package com.monday.start.domain.entities

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore

@Entity
@Table(name = "questions")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val text: String? = null,
    val multiple: Boolean = false,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val answers: List<Answer> = emptyList(),

    @ManyToOne
    @JoinColumn(name = "question_data_id")
    @JsonBackReference
    @JsonIgnore
    val questionData: QuestionData? = null
)