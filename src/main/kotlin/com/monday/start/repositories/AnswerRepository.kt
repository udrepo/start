package com.monday.start.repositories

import com.monday.start.domain.entities.Answer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository : JpaRepository<Answer?, Long?>