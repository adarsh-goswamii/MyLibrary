package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Intent intent=getIntent();
        if(intent!=null)
        {
            int bookId= intent.getIntExtra("bookId", -1);
            if(bookId!=-1)
            {
                Books bookIncoming= Utils.getInstance().getBookById(bookId);
                if(bookIncoming!=null)
                    setData(bookIncoming);
            }
        }

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