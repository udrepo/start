package com.monday.start.repositories


import com.monday.start.domain.entities.QuestionData
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionDataRepository : JpaRepository<QuestionData?, Long?> {
}