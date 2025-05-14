package com.example.notes.NoteDao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notes.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("INSERT INTO NotesTable (text) VALUES ('Second Note')")
    void create();

    @Query("SELECT * FROM NotesTable")
    List<Note> getALl();

    @Query("SELECT * FROM NotesTable WHERE id IN (:noteIds)")
    List<Note> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM NotesTable WHERE text LIKE :text LIMIT 1")
    Note findByText(String text);

    @Insert
    void insertAll(Note... notes);

    @Delete
    void delete(Note note);
}
