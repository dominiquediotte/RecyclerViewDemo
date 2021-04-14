package com.example.recyclerviewdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.adapters.TodoRecyclerViewAdapter;
import com.example.recyclerviewdemo.models.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    private List<Todo> mTodos = new ArrayList<>();

    private Button mAddTodoButton;
    private RecyclerView mTodosRecyclerView;
    private RecyclerView.Adapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        referenceViews();
        initializeRecyclerView();
        setListeners();
    }

    private void initializeRecyclerView() {
        mTodosRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mTodosRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new TodoRecyclerViewAdapter(mTodos);
        mTodosRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void setListeners() {
        mAddTodoButton.setOnClickListener(v -> {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_add_todo);
            dialog.setTitle("Add todo");

            Button addButton = dialog.findViewById(R.id.button_add);

            addButton.setOnClickListener(v1 -> {
                EditText titleEditText = dialog.findViewById(R.id.edit_text_title);
                EditText descriptionEditText = dialog.findViewById(R.id.edit_text_description);
                Todo todoToAdd = new Todo(new Date(), titleEditText.getText().toString(), descriptionEditText.getText().toString());
                mTodos.add(todoToAdd);
                mRecyclerViewAdapter.notifyDataSetChanged();
                dialog.dismiss();
            });

            dialog.show();
        });
    }

    private void referenceViews() {
        mAddTodoButton = findViewById(R.id.button_add_todo);
        mTodosRecyclerView = findViewById(R.id.recycler_view_todos);
    }
}