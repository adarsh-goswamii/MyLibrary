package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

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
            final int bookId= intent.getIntExtra("bookId", -1);
            if(bookId!=-1)
            {
                final Books bookIncoming= Utils.getInstance().getBookById(bookId);
                if(bookIncoming!=null)
                {
                    setData(bookIncoming);

                    if(handleAlreadyRead(bookIncoming))
                        read.setEnabled(false);
                    else
                        read.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(Utils.getInstance().addToAlreadyRead(bookIncoming))
                                {
                                    Toast.makeText(BookActivity.this, "Book Successfully Added", Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(BookActivity.this, AlreadyReadActivity.class);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(BookActivity.this, "OOPS! Something Went Wrong, please try again", Toast.LENGTH_SHORT).show();
                            }
                        });

                    if(handleWishList(bookIncoming))
                        wishlist.setEnabled(false);
                    else
                    {
                        wishlist.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(Utils.getInstance().addToWishList(bookIncoming))
                                {
                                    Toast.makeText(BookActivity.this, "Book Successfully Added", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(BookActivity.this, WishListActivity.class);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(BookActivity.this, "OOPS! Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    if(handleFav(bookIncoming))
                        fav.setEnabled(false);
                    else
                    {
                        fav.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(Utils.getInstance().addToFav(bookIncoming))
                                {
                                    Toast.makeText(BookActivity.this, "Book Successfully Added", Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(BookActivity.this, FavouriteActivity.class);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(BookActivity.this, "OOPS! Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    if(handleCurrentlyReading(bookIncoming))
                        reading.setEnabled(false);
                    else
                    {
                        reading.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(Utils.getInstance().addToCurrentlyReading(bookIncoming))
                                {
                                    Toast.makeText(BookActivity.this, "Book Successfully Added", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(BookActivity.this, CurrentlyReadingActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                }
                                else
                                    Toast.makeText(BookActivity.this, "OOPS! Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        }

    }

    public boolean handleWishList(Books book)
    {
        ArrayList<Books> book_list= Utils.getInstance().getWishList();
        for(Books b: book_list)
            if(b.getId()== book.getId())
                return true;
            return false;
    }

    public boolean handleAlreadyRead(Books book)
    {
        ArrayList<Books> book_list= Utils.getInstance().getAlreadyRead();
        for(Books b: book_list)
            if(b.getId()== book.getId())
                return true;
            return false;
    }

    public boolean handleFav(Books book)
    {
        ArrayList<Books> list_book= Utils.getInstance().getFavBooks();
        for(Books b: list_book)
            if(b.getId()== book.getId())
                return true;
            return false;
    }

    public boolean handleCurrentlyReading(Books book)
    {
        ArrayList<Books> list_book= Utils.getInstance().getCurrently();
        for(Books b: list_book)
            if(b.getId()== book.getId())
                return true;
            return false;
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