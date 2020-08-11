package com.example.mylibrary;

import java.util.ArrayList;

public class Utils
{
    private static Utils instance;
    private static ArrayList<Books> allBooks, alreadyRead, wishList, favBooks, currently;
    private Utils()
    {
        if(allBooks==null)
        {
            allBooks = new ArrayList<Books>();
            initData();
        }
        if(alreadyRead==null)
           alreadyRead=new ArrayList<Books>();
        if(wishList==null)
            wishList=new ArrayList<Books>();
        if(favBooks==null)
            favBooks=new ArrayList<Books>();
        if(currently==null)
            currently=new ArrayList<Books>();
    }

    private void initData()
    {
        allBooks.add(new Books("The Monk Who Sold His Ferrari", "Robin Sharma", "ShortDesc", "LongDesc", "https://images-na.ssl-images-amazon.com/images/I/61Iz2yy2CKL.jpg", 350, 123));
        allBooks.add(new Books("Death Note", "Adarsh Goswami", "Write the name of the person and he will die", "longDesc", "https://i.pinimg.com/474x/59/94/15/5994155f280a34fcd94b0ee0a7507448.jpg", 100, 124));
        allBooks.add(new Books("The Adventures of Sherlock Holmes", "Sir Arthur Conan Doyle", "The Adventures of Sherlock Holmes is a collection of twelve short stories by Arthur Conan Doyle.", "In general the stories in The Adventures of Sherlock Holmes identify, and try to correct, social injustices. Holmes is portrayed as offering a new, fairer sense of justice. The stories were well received, and boosted the subscriptions figures of The Strand Magazine, prompting Doyle to be able to demand more money for his next set of stories. The first story, \"A Scandal in Bohemia\", includes the character of Irene Adler, who, despite being featured only within this one story by Doyle, is a prominent character in modern Sherlock Holmes adaptations, generally as a love interest for Holmes. Doyle included four of the twelve stories from this collection in his twelve favourite Sherlock Holmes stories, picking \"The Adventure of the Speckled Band\" as his overall favourite.", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Adventures_of_sherlock_holmes.jpg/330px-Adventures_of_sherlock_holmes.jpg", 350, 125));
        allBooks.add(new Books("The Power of Your Subconscious Mind", "Joseph Murphy", "ShortDesc", "Search Results\n" +
                "Featured snippet from the web\n" +
                "Your conscious mind does the thinking, and its thoughts sink into the subconscious. Your subconscious accepts these thoughts and acts on them. Whatever your conscious thoughts are, they produce a similar result in the subconscious. Think good things, and good will appear in your life.", "https://i.pinimg.com/474x/d6/93/a0/d693a0b2655327193ea91fabd116877c.jpg", 450, 126));
        allBooks.add(new Books("Srimad Bhagavad Gita", "Vyasa", " 700-verse Hindu scripture that is part of the epic Mahabharata (chapters 23–40 of Bhishma Parva), commonly dated to the second century BCE.", "The Gita is set in a narrative framework of a dialogue between Pandava prince Arjuna and his guide and charioteer Krishna. At the start of the Dharma Yudhha (righteous war) between Pandavas and Kauravas, Arjuna is filled with moral dilemma and despair about the violence and death the war will cause in the battle against his own kin.[2] He wonders if he should renounce and seeks Krishna's counsel, whose answers and discourse constitute the Bhagavad Gita. Krishna counsels Arjuna to \"fulfill his Kshatriya (warrior) duty to uphold the Dharma\" through \"selfless action\".[web 1][3][note 1] The Krishna–Arjuna dialogues cover a broad range of spiritual topics, touching upon ethical dilemmas and philosophical issues that go far beyond the war Arjuna faces.[1][4][5]", "https://i.pinimg.com/474x/59/ee/8f/59ee8fc3012eed6167f6379ea8b80016.jpg", 350, 127));
    }

    public static ArrayList<Books> getCurrently() {
        return currently;
    }

    public static Utils getInstance()
    {
        if(instance==null)
            return new Utils();
        else
            return instance;
    }

    public static ArrayList<Books> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Books> getAlreadyRead() {
        return alreadyRead;
    }

    public static ArrayList<Books> getWishList() {
        return wishList;
    }

    public static ArrayList<Books> getFavBooks() {
        return favBooks;
    }

    public boolean addToCurrentlyReading(Books book)
    {
        return currently.add(book);
    }

    public Books getBookById(int bookId)
    {
        for(Books b: allBooks)
            if(b.getId()== bookId)
                return b;
            return null;
    }

    public boolean addToAlreadyRead(Books book)
    {
        return alreadyRead.add(book);
    }
    public boolean addToWishList(Books book)
    {
        return wishList.add(book);
    }
    public boolean addToFav(Books book){
        return favBooks.add(book);
    }
}
