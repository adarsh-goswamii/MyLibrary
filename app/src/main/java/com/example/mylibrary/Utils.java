package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils
{
    private static Utils instance;
    private SharedPreferences sharedPreferences;
    private static final String ALL_BOOKS_KEY= "all", WISHLIST_KEY= "wish", FAVOURITE_KEY="fav";
    private static final String CURRENTLY_KEY= "currently", ALREADY_READ_KEY="already";
    //private static ArrayList<Books> allBooks, alreadyRead, wishList, favBooks, currently;
    private Utils(Context context)
    {
        sharedPreferences= context.getSharedPreferences("alternate_db", Context.MODE_PRIVATE);

        if(getAllBooks()==null)
            initData();

        if(getAlreadyRead()==null)
        {
            ArrayList<Books> alreadyRead= new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(ALREADY_READ_KEY, gson.toJson(alreadyRead));
            editor.commit();
        }
        if(getWishList()==null)
        {
            ArrayList<Books> alreadyRead= new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(WISHLIST_KEY, gson.toJson(alreadyRead));
            editor.commit();
        }
        if(getFavBooks()==null)
        {
            ArrayList<Books> alreadyRead= new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(FAVOURITE_KEY, gson.toJson(alreadyRead));
            editor.commit();
        }
        if(getCurrently()==null)
        {
            ArrayList<Books> alreadyRead= new ArrayList<>();
            Gson gson=new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString(CURRENTLY_KEY, gson.toJson(alreadyRead));
            editor.commit();
        }
    }

    private void initData()
    {
        ArrayList<Books> allBooks=new ArrayList<>();
        allBooks.add(new Books("The Monk Who Sold His Ferrari", "Robin Sharma", "ShortDesc", "LongDesc", "https://images-na.ssl-images-amazon.com/images/I/61Iz2yy2CKL.jpg", 350, 123));
        allBooks.add(new Books("Death Note", "Adarsh Goswami", "Write the name of the person and he will die", "longDesc", "https://i.pinimg.com/474x/59/94/15/5994155f280a34fcd94b0ee0a7507448.jpg", 100, 124));
        allBooks.add(new Books("The Adventures of Sherlock Holmes", "Sir Arthur Conan Doyle", "The Adventures of Sherlock Holmes is a collection of twelve short stories by Arthur Conan Doyle.", "In general the stories in The Adventures of Sherlock Holmes identify, and try to correct, social injustices. Holmes is portrayed as offering a new, fairer sense of justice. The stories were well received, and boosted the subscriptions figures of The Strand Magazine, prompting Doyle to be able to demand more money for his next set of stories. The first story, \"A Scandal in Bohemia\", includes the character of Irene Adler, who, despite being featured only within this one story by Doyle, is a prominent character in modern Sherlock Holmes adaptations, generally as a love interest for Holmes. Doyle included four of the twelve stories from this collection in his twelve favourite Sherlock Holmes stories, picking \"The Adventure of the Speckled Band\" as his overall favourite.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Adventures_of_sherlock_holmes.jpg/330px-Adventures_of_sherlock_holmes.jpg", 350, 125));
        allBooks.add(new Books("The Power of Your Subconscious Mind", "Joseph Murphy", "ShortDesc", "Search Results\n" +
                "Featured snippet from the web\n" +
                "Your conscious mind does the thinking, and its thoughts sink into the subconscious. Your subconscious accepts these thoughts and acts on them. Whatever your conscious thoughts are, they produce a similar result in the subconscious. Think good things, and good will appear in your life.", "https://i.pinimg.com/474x/d6/93/a0/d693a0b2655327193ea91fabd116877c.jpg", 450, 126));
        allBooks.add(new Books("Srimad Bhagavad Gita", "Vyasa", " 700-verse Hindu scripture that is part of the epic Mahabharata (chapters 23–40 of Bhishma Parva), commonly dated to the second century BCE.", "The Gita is set in a narrative framework of a dialogue between Pandava prince Arjuna and his guide and charioteer Krishna. At the start of the Dharma Yudhha (righteous war) between Pandavas and Kauravas, Arjuna is filled with moral dilemma and despair about the violence and death the war will cause in the battle against his own kin.[2] He wonders if he should renounce and seeks Krishna's counsel, whose answers and discourse constitute the Bhagavad Gita. Krishna counsels Arjuna to \"fulfill his Kshatriya (warrior) duty to uphold the Dharma\" through \"selfless action\".[web 1][3][note 1] The Krishna–Arjuna dialogues cover a broad range of spiritual topics, touching upon ethical dilemmas and philosophical issues that go far beyond the war Arjuna faces.[1][4][5]", "https://i.pinimg.com/474x/59/ee/8f/59ee8fc3012eed6167f6379ea8b80016.jpg", 350, 127));
        Gson gson=new Gson();
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(ALL_BOOKS_KEY, gson.toJson(allBooks));
        editor.commit();
    }

    public ArrayList<Books> getCurrently() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> allbooks= gson.fromJson(sharedPreferences.getString(CURRENTLY_KEY, null), type);
        return allbooks;
    }

    public static Utils getInstance(Context context)
    {
        if(instance==null)
            return new Utils(context);
        else
            return instance;
    }

    public ArrayList<Books> getAllBooks()
    {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> allbooks= gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        return allbooks;
    }

    public ArrayList<Books> getAlreadyRead() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> alreadyRead= gson.fromJson(sharedPreferences.getString(ALREADY_READ_KEY, null), type);
        return alreadyRead;
    }

    public ArrayList<Books> getWishList() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> wishList= gson.fromJson(sharedPreferences.getString(WISHLIST_KEY, null), type);
        return wishList;
    }

    public ArrayList<Books> getFavBooks() {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> fav= gson.fromJson(sharedPreferences.getString(FAVOURITE_KEY, null), type);
        return fav;
    }

    public boolean addToCurrentlyReading(Books book)
    {
        ArrayList<Books> currently= getCurrently();

        if(currently!=null)
        {
            if(currently.add(book))
            {
                Gson gson= new Gson();
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(CURRENTLY_KEY);
                editor.putString(CURRENTLY_KEY, gson.toJson(currently));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public Books getBookById(int bookId)
    {
        Gson gson=new Gson();
        Type type=new TypeToken<ArrayList<Books>>(){}.getType();
        ArrayList<Books> allBooks= gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY, null), type);
        if(allBooks!=null) {
            for (Books b : allBooks)
                if (b.getId() == bookId)
                    return b;
        }

        return null;
    }

    public boolean addToAlreadyRead(Books book)
    {
        ArrayList<Books> currently= getAlreadyRead();

        if(currently!=null)
        {
            if(currently.add(book))
            {
                Gson gson= new Gson();
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(ALREADY_READ_KEY);
                editor.putString(ALREADY_READ_KEY, gson.toJson(currently));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToWishList(Books book)
    {
        ArrayList<Books> currently= getWishList();

        if(currently!=null)
        {
            if(currently.add(book))
            {
                Gson gson= new Gson();
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(WISHLIST_KEY);
                editor.putString(WISHLIST_KEY, gson.toJson(currently));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addToFav(Books book)
    {
        ArrayList<Books> currently= getFavBooks();

        if(currently!=null)
        {
            if(currently.add(book))
            {
                Gson gson= new Gson();
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.remove(FAVOURITE_KEY);
                editor.putString(FAVOURITE_KEY, gson.toJson(currently));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean removeFromWishList(Books book)
    {
        ArrayList<Books> currently= getWishList();

        if(currently!=null)
        {
            Gson gson= new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.remove(WISHLIST_KEY);
            for(Books b: currently)
                if(b.getId()== book.getId())
                    currently.remove(b);

            editor.putString(WISHLIST_KEY, gson.toJson(currently));
            editor.commit();
            return true;
        }
        return false;
    }

    public boolean removeFromFav(Books book)
    {
        ArrayList<Books> currently= getFavBooks();

        if(currently!=null)
        {
            Gson gson= new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.remove(FAVOURITE_KEY);
            for(Books b: currently)
                if(b.getId()== book.getId())
                    currently.remove(b);

            editor.putString(FAVOURITE_KEY, gson.toJson(currently));
            editor.commit();
            return true;
        }
        return false;
    }

    public boolean removeFromAlreadyRead(Books book)
    {
        ArrayList<Books> currently= getAlreadyRead();

        if(currently!=null)
        {
            Gson gson= new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.remove(ALREADY_READ_KEY);
            for(Books b: currently)
                if(b.getId()== book.getId())
                    currently.remove(b);

            editor.putString(ALREADY_READ_KEY, gson.toJson(currently));
            editor.commit();
            return true;
        }
        return false;
    }

    public boolean removeFromCurrentlyReading(Books book)
    {
        ArrayList<Books> currently= getCurrently();

        if(currently!=null)
        {
            Gson gson= new Gson();
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.remove(CURRENTLY_KEY);
            for(Books b: currently)
                if(b.getId()== book.getId())
                    currently.remove(b);

            editor.putString(CURRENTLY_KEY, gson.toJson(currently));
            editor.commit();
            return true;
        }
        return false;
    }
}
