package com.monday.start.domain.dto

data class QuestionDto(
    val text: String?,
    val multiple: Boolean = false,
    val answers: List<AnswerDto> = emptyList()
)