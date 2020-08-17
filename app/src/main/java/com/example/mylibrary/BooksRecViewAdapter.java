package com.example.mylibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>
{
    private Context mContext;
    private ArrayList<Books> books=new ArrayList<>();
    static final String TAG="BooksRecView";
    private String parentActivity;

    public BooksRecViewAdapter(Context mContext, String str) {
        this.mContext = mContext;
        parentActivity= str;
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "BooksRecViewAdapter called");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext).asBitmap().load(books.get(position).getImageUrl()).into(holder.imgBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, BookActivity.class);
                intent.putExtra("bookId", books.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        holder.shortDesc.setText(books.get(position).getShortDesc());
        holder.textAuthor.setText(books.get(position).getAuthor());

        if(books.get(position).isExpanded())
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
        }
        else
        {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }

        if(parentActivity.equals("AlreadyRead"))
        {
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                    builder.setMessage("Are you sure you wan't to delete "+ books.get(position).getName()+"?.");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String name= books.get(position).getName();
                            if(Utils.getInstance(mContext).removeFromAlreadyRead(books.get(position)))
                            {
                                Toast.makeText(mContext,"Book "+name+" deleted successfully.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                            else
                                Toast.makeText(mContext, "OOPS! Something went wrong please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Nothing
                        }
                    });

                    builder.create().show();
                }
            });

        }
        else if(parentActivity.equals("WishList"))
        {
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                    builder.setMessage("Are you sure you wan't to delete "+ books.get(position).getName()+"?.");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String name= books.get(position).getName();
                            if(Utils.getInstance(mContext).removeFromWishList(books.get(position)))
                            {
                                Toast.makeText(mContext,"Book "+name+" deleted successfully.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                            else
                                Toast.makeText(mContext, "OOPS! Something went wrong please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Nothing
                        }
                    });

                    builder.create().show();
                }
            });
        }
        else if(parentActivity.equals("Favourite"))
        {
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                    builder.setMessage("Are you sure you wan't to delete "+ books.get(position).getName()+"?.");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String name= books.get(position).getName();
                            if(Utils.getInstance(mContext).removeFromFav(books.get(position)))
                            {
                                Toast.makeText(mContext,"Book "+name+" deleted successfully.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                            else
                                Toast.makeText(mContext, "OOPS! Something went wrong please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Nothing
                        }
                    });

                    builder.create().show();
                }
            });
        }
        else if(parentActivity.equals("CurrentlyReading"))
        {
            holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(mContext);
                    builder.setMessage("Are you sure you wan't to delete "+ books.get(position).getName()+"?.");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String name= books.get(position).getName();
                            if(Utils.getInstance(mContext).removeFromCurrentlyReading(books.get(position)))
                            {
                                Toast.makeText(mContext,"Book "+name+" deleted successfully.", Toast.LENGTH_SHORT).show();
                                notifyDataSetChanged();
                            }
                            else
                                Toast.makeText(mContext, "OOPS! Something went wrong please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Nothing
                        }
                    });

                    builder.create().show();
                }
            });
        }
        else
            holder.btnDelete.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private TextView textAuthor, shortDesc;
        private ImageView upArrow, downArrow;
        private RelativeLayout collapsed, expanded;
        private TextView btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent= itemView.findViewById(R.id.parent);
            imgBook= itemView.findViewById(R.id.imgBook);
            txtName= itemView.findViewById(R.id.txtName);
            textAuthor= itemView.findViewById(R.id.textAuthor);
            shortDesc= itemView.findViewById(R.id.shortDesc);
            upArrow= itemView.findViewById(R.id.upArrow);
            downArrow= itemView.findViewById(R.id.downArrow);
            collapsed= itemView.findViewById(R.id.collapsedRelLayout);
            expanded= itemView.findViewById(R.id.expand);
            btnDelete= itemView.findViewById(R.id.btnDelete);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Books book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
