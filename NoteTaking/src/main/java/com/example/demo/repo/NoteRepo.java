package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Notes;
public interface NoteRepo extends JpaRepository<Notes, Integer>{

}
