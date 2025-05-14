package com.example.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "NotesTable")
public class Note {
    @PrimaryKey
    public int id;

    @ColumnInfo(name="text")
    public String text;
}
