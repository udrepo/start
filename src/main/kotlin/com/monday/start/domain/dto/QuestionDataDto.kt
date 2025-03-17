package com.monday.start.domain.dto

import com.monday.start.domain.entities.Question

data class QuestionDataDto(
    val id: Long?,
    val comment: String?,
    val mapping: Boolean = false,
    val questionCode: String?,
    val mappingQuestion: String?,
    val solution: String?,
    val imageUrl: String?,
    val questions: List<QuestionDto> = emptyList()
)
