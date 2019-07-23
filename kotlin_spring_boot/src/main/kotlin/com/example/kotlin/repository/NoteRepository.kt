package com.example.kotlin.repository

import com.example.kotlin.model.Note
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface NoteRepository : CrudRepository<Note, Long> {
}