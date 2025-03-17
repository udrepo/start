package com.monday.start.domain.dto

data class AnswerDto(
    val answer: String?,
    val isCorrect: Boolean = false
)