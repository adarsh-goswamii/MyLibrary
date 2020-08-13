package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button allBooks, currentlyReading, alreadyRead, wishList, favourite, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        allBooks= findViewById(R.id.btnAll);
        currentlyReading= findViewById(R.id.btnCurrentlyReading);
        alreadyRead= findViewById(R.id.btnAlreadyRead);
        wishList= findViewById(R.id.btnWishlist);
        favourite= findViewById(R.id.btnFav);
        about= findViewById(R.id.btnAbout);
        Utils.getInstance();
        allBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, AllBookActivity.class);
                startActivity(intent);
            }
        });

        currentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        alreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, FavouriteActivity.class);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity2.this);
                builder.setTitle("My Library");
                builder.setMessage("Designed and Developed by Adarsh Goswami.\n To check out more awesome stuffs from the designer select visit");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity2.this, AboutActivity.class);
                        intent.putExtra("url", "https://github.com/Adarsh-Goswamii");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
    }
}