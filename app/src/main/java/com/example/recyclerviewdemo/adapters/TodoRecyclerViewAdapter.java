package com.example.recyclerviewdemo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.models.Todo;

import java.util.Date;
import java.util.List;

public class TodoRecyclerViewAdapter extends RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder> {

    private List<Todo> mTodos;

    public TodoRecyclerViewAdapter(List<Todo> todos) {
        this.mTodos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todoToBind = mTodos.get(position);

        holder.setTitle(todoToBind.getTitle());
        holder.setDescription(todoToBind.getDescription());
        holder.setDate(todoToBind.getDateAdded());
    }

    @Override
    public int getItemCount() {
        return mTodos.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private TextView mDateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.text_view_title);
            mDescriptionTextView = itemView.findViewById(R.id.text_view_description);
            mDateTextView = itemView.findViewById(R.id.text_view_date);
        }

        public void setTitle(String title) {
            mTitleTextView.setText(title);
        }

        public void setDescription(String description) {
            mDescriptionTextView.setText(description);
        }

        public void setDate(Date date) {
            mDateTextView.setText(date.toString());
        }
    }
}
