package com.monday.start.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "m_users")
class User {
    @Id
    @Column(name = "id", nullable = false, length = Integer.MAX_VALUE)
    var id: String? = null

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    var name: String? = null

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    @JsonIgnore
    var password: String? = null
}