package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBookActivity extends AppCompatActivity {

    private RecyclerView bookRecView;
    private BooksRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);

        adapter= new BooksRecViewAdapter(this);
        bookRecView= findViewById(R.id.booksRecView);
        bookRecView.setAdapter(adapter);
        bookRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Books> books=new ArrayList<>();
        books.add(new Books("The Monk Who Sold His Ferrari", "Robin Sharma", "ShortDesc", "LongDesc", "https://images-na.ssl-images-amazon.com/images/I/61Iz2yy2CKL.jpg", 350, 123));
        books.add(new Books("Death Note", "Adarsh Goswami", "Write the name of the person and he will die", "longDesc", "https://i.pinimg.com/474x/59/94/15/5994155f280a34fcd94b0ee0a7507448.jpg", 100, 124));
        adapter.setBooks(books);
    }
}