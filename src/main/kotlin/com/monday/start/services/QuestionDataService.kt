package com.monday.start.services

import com.monday.start.*
import com.monday.start.domain.dto.QuestionDataDto
import com.monday.start.domain.entities.Answer
import com.monday.start.domain.entities.QuestionData
import com.monday.start.repositories.AnswerRepository
import com.monday.start.repositories.QuestionDataRepository
import com.monday.start.repositories.QuestionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuestionDataService(
    private val questionDataRepository: QuestionDataRepository,
    private val questionRepository: QuestionRepository,
    private val answerRepository: AnswerRepository,
) {

    fun getAllQuestionData(): MutableList<QuestionData?> {
        return questionDataRepository.findAll()
    }

    fun getQuestionDataById(id: Long): QuestionDataDto? {
        val questionData = questionDataRepository.findById(id)
            .orElseThrow { IllegalArgumentException("QuestionData with ID $id not found") }

        return questionData?.toQuestionDataDto()
    }

    @Transactional
    fun createQuestionData(dto: QuestionDataDto): QuestionData {
        val qData = questionDataRepository.save(dto.toQuestionData())

        val questions = dto.questions.map { it.toQuestion(qData) }

        val savedQuestions = questionRepository.saveAll(questions)

        val size: Int = savedQuestions.size

        val answersList: MutableList<Answer> = mutableListOf()

        for (i in size - 1 downTo 0) {
            dto.questions[i].answers.forEach { answersList.add(it.toAnswer(savedQuestions[i])) }
        }

        answerRepository.saveAll(answersList)

        return questionDataRepository.getReferenceById(qData.id!!)
    }
}
