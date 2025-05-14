package com.example.notes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.notes.NoteDao.NoteDao;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
