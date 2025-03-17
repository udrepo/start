package com.monday.start

import com.monday.start.domain.dto.AnswerDto
import com.monday.start.domain.dto.QuestionDataDto
import com.monday.start.domain.dto.QuestionDto
import com.monday.start.domain.entities.Answer
import com.monday.start.domain.entities.Question
import com.monday.start.domain.entities.QuestionData

fun QuestionData.toQuestionDataDto(): QuestionDataDto {
    return QuestionDataDto(
        comment = this.comment,
        mapping = this.mapping,
        questionCode = this.questionCode,
        mappingQuestion = this.mappingQuestion,
        solution = this.solution,
        imageUrl = this.imageUrl,
        questions = this.questions.map { it.toQuestionDto() },
        id = this.id
    )
}

fun QuestionDataDto.toQuestionData(): QuestionData {
    return QuestionData(
        comment = this.comment,
        mapping = this.mapping,
        questionCode = this.questionCode,
        solution = this.solution,
        imageUrl = this.imageUrl,

        id = this.id,
        mappingQuestion = this.mappingQuestion,
    )
}

fun Question.toQuestionDto(): QuestionDto {
    return QuestionDto(
        text = this.text,
        multiple = this.multiple,
        answers = this.answers.map { it.toAnswerDto() },
    )
}

fun QuestionDto.toQuestion(questionData: QuestionData): Question {
    return Question(
        text = this.text,
        multiple = this.multiple,
        answers = mutableListOf(),
        questionData = questionData,
    )
}

fun Answer.toAnswerDto(): AnswerDto {
    return AnswerDto(
        answer = this.answer,
        isCorrect = this.isCorrect
    )
}

fun AnswerDto.toAnswer(question: Question): Answer {
    return Answer(
        answer = this.answer,
        isCorrect = this.isCorrect,
        question = question
    )
}