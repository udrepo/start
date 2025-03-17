package com.monday.start.domain.entities

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonManagedReference

@Entity
@Table(name = "question_data")
data class QuestionData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val comment: String?,
    val mapping: Boolean = false,
    val questionCode: String?,
    val mappingQuestion: String?,
    val solution: String?,
    val imageUrl: String?, // New field added

    @OneToMany(mappedBy = "questionData", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val questions: List<Question> = emptyList()
)