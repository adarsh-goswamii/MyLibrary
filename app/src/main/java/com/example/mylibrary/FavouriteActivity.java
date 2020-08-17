package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        RecyclerView recView= findViewById(R.id.recViewFav);
        BooksRecViewAdapter adapter=new BooksRecViewAdapter(this, "Favourite");
        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance(FavouriteActivity.this).getFavBooks());
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(FavouriteActivity.this, MainActivity2.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}