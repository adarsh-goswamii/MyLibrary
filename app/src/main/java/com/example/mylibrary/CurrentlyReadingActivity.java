package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        RecyclerView recView= findViewById(R.id.recViewCurrently);
        BooksRecViewAdapter adapter=new BooksRecViewAdapter(this, "CurrentlyReading");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance().getCurrently());
    }

    @Override
    public void onBackPressed()
    {
        Intent intent=new Intent(CurrentlyReadingActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}