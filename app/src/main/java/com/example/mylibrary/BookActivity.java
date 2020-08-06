package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    private ImageView image;
    private TextView longDesc, author, name, page;
    private Button wishlist, fav, reading, read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        image= findViewById(R.id.bookImage);
        longDesc= findViewById(R.id.bookLongDesc);
        author= findViewById(R.id.bookAuthor);
        name= findViewById(R.id.bookName);
        wishlist= findViewById(R.id.bookWishlist);
        fav= findViewById(R.id.bookAddfav);
        reading= findViewById(R.id.bookCurrReading);
        read= findViewById(R.id.bookAlreadyRead);
        page= findViewById(R.id.bookPage);

        Books book=new Books("Death Note", "Adarsh Goswami", "Write the name of the person and he will die", "Overview of inheritance, Working with subclasses and superclasses, " +
                "Overriding methods in the superclass, Introducing polymorphism, Creating and extending abstract" +
                "classes, Modeling business problems using Java classes, Making classes immutable", "https://i.pinimg.com/474x/59/94/15/5994155f280a34fcd94b0ee0a7507448.jpg", 100, 124);
        setData(book);
    }

    public void setData(Books book)
    {
        this.longDesc.setText(book.getLongDesc());
        this.name.setText(book.getName());
        this.author.setText(book.getAuthor());
        this.page.setText(book.getPages()+"");
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(image);
    }
}