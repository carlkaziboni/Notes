package com.example.notes;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private List<Note> notes;
    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        LinearLayout container;
        NoteViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.note_row_text);
            container = view.findViewById(R.id.note_row);

            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note currentNote = (Note) container.getTag();
                    Intent intent = new Intent(v.getContext(), NoteActivity.class);
                    intent.putExtra("contents", currentNote.text);
                    intent.putExtra("id", currentNote.id);
                    v.getContext().startActivity(intent);
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row_item, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.container.setTag(note);
        holder.getTextView().setText(note.text);


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

}
