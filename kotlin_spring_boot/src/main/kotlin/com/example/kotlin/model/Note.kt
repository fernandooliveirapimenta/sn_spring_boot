package com.example.kotlin.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Note (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,
        val title: String,
        val body: String
)