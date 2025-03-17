package com.monday.start.controllers

import com.monday.start.domain.dto.QuestionDataDto
import com.monday.start.domain.entities.QuestionData
import com.monday.start.repositories.QuestionDataRepository
import com.monday.start.services.QuestionDataService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/question_data")
class QuestionDataController(
    private val questionDataService: QuestionDataService
) {

    @GetMapping
    fun getAllQuestionData(): ResponseEntity<MutableList<QuestionData?>> {
        val questionData = questionDataService.getAllQuestionData()
        return ResponseEntity(questionData, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getQuestionDataById(@PathVariable id: Long): ResponseEntity<QuestionDataDto> {
        val questionDataDto = questionDataService.getQuestionDataById(id)
        return ResponseEntity.ok(questionDataDto)
    }

    @PostMapping
    fun createQuestionData(@RequestBody dto: QuestionDataDto): ResponseEntity<QuestionData> {
        val savedQuestionData = questionDataService.createQuestionData(dto)
        return ResponseEntity(savedQuestionData, HttpStatus.CREATED)
    }

}