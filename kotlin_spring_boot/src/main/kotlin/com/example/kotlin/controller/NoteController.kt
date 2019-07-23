package com.example.kotlin.controller

import com.example.kotlin.model.Note
import com.example.kotlin.repository.NoteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(val noteRepository: NoteRepository) {

    @GetMapping
    fun findAll(): Iterable<Note> = noteRepository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Note>
            = noteRepository.findById(id)
            .map { note -> ResponseEntity.ok(note) }.orElse(ResponseEntity.noContent().build())

    @PostMapping
    fun create(@RequestBody note: Note) = noteRepository.save(note)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note>{
        return noteRepository.findById(id).map { note ->
             val updated: Note = note.copy(title = note.title, body = note.body);
             ResponseEntity.ok(noteRepository.save(updated));
         }.orElse(ResponseEntity.noContent().build())
    }

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Long) = noteRepository.deleteById(id)


}