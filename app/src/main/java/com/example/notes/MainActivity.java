package com.example.notes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.notes.NoteDao.NoteDao;

public class MainActivity extends AppCompatActivity {
    public static NotesDatabase db;
    NoteDao noteDao;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);

        db = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "database-name").allowMainThreadQueries().build();
        noteDao = db.noteDao();

        recyclerView = findViewById(R.id.notes_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new NotesAdapter(noteDao.getALl());
        recyclerView.setAdapter(adapter);
        //noteDao.create();
        adapter.setNotes(noteDao.getALl());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}