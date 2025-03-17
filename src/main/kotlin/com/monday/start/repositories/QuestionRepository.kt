package com.monday.start.repositories

import com.monday.start.domain.entities.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question?, Long?>