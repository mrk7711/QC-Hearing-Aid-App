package com.example.cab2u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList book_id, book_title, book_author, book_pages, book_pages2, book_pages3, book_pages4, book_pages5, book_pages6,
            book_pages7, book_pages8, book_pages9, book_pages10, book_pages11, book_pages12, book_pages13;

    CustomAdapter(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author,
                  ArrayList book_pages, ArrayList book_pages2, ArrayList book_pages3,
                  ArrayList book_pages4, ArrayList book_pages5, ArrayList book_pages6,
                  ArrayList book_pages7, ArrayList book_pages8, ArrayList book_pages9,
                  ArrayList book_pages10, ArrayList book_pages11, ArrayList book_pages12, ArrayList book_pages13){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
        this.book_pages2 = book_pages2;
        this.book_pages3 = book_pages3;
        this.book_pages4 = book_pages4;
        this.book_pages5 = book_pages5;
        this.book_pages6 = book_pages6;
        this.book_pages7 = book_pages7;
        this.book_pages8 = book_pages8;
        this.book_pages9 = book_pages9;
        this.book_pages10 = book_pages10;
        this.book_pages11 = book_pages11;
        this.book_pages12 = book_pages12;
        this.book_pages13 = book_pages13;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        holder.book_pages2_txt.setText(String.valueOf(book_pages2.get(position)));
        holder.book_pages3_txt.setText(String.valueOf(book_pages3.get(position)));
        holder.book_pages4_txt.setText(String.valueOf(book_pages4.get(position)));
        holder.book_pages5_txt.setText(String.valueOf(book_pages5.get(position)));
        holder.book_pages6_txt.setText(String.valueOf(book_pages6.get(position)));
        holder.book_pages7_txt.setText(String.valueOf(book_pages7.get(position)));
        holder.book_pages8_txt.setText(String.valueOf(book_pages8.get(position)));
        holder.book_pages9_txt.setText(String.valueOf(book_pages9.get(position)));
        holder.book_pages10_txt.setText(String.valueOf(book_pages10.get(position)));
        holder.book_pages11_txt.setText(String.valueOf(book_pages11.get(position)));
        holder.book_pages12_txt.setText(String.valueOf(book_pages12.get(position)));
        holder.book_pages13_txt.setText(String.valueOf(book_pages13.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SelectionActivity.class);
                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                 intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
//                intent.putExtra("pages2", String.valueOf(book_pages2.get(position)));
//                intent.putExtra("pages3", String.valueOf(book_pages3.get(position)));
//                intent.putExtra("pages4", String.valueOf(book_pages4.get(position)));
//                intent.putExtra("pages5", String.valueOf(book_pages5.get(position)));
//                intent.putExtra("pages6", String.valueOf(book_pages6.get(position)));
//                intent.putExtra("pages7", String.valueOf(book_pages7.get(position)));
//                intent.putExtra("pages8", String.valueOf(book_pages8.get(position)));
//                intent.putExtra("pages9", String.valueOf(book_pages9.get(position)));
//                intent.putExtra("pages10", String.valueOf(book_pages10.get(position)));
//                intent.putExtra("pages11", String.valueOf(book_pages11.get(position)));
//                intent.putExtra("pages12", String.valueOf(book_pages12.get(position)));
//                intent.putExtra("pages13", String.valueOf(book_pages13.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt, book_pages2_txt, book_pages3_txt, book_pages4_txt,
                book_pages5_txt, book_pages6_txt, book_pages7_txt,book_pages8_txt, book_pages9_txt, book_pages10_txt,
                book_pages11_txt, book_pages12_txt, book_pages13_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            book_pages2_txt = itemView.findViewById(R.id.book_pages2_txt);
            book_pages3_txt = itemView.findViewById(R.id.book_pages3_txt);
            book_pages4_txt = itemView.findViewById(R.id.book_pages4_txt);
            book_pages5_txt = itemView.findViewById(R.id.book_pages5_txt);
            book_pages6_txt = itemView.findViewById(R.id.book_pages6_txt);
            book_pages7_txt = itemView.findViewById(R.id.book_pages7_txt);
            book_pages8_txt = itemView.findViewById(R.id.book_pages8_txt);
            book_pages9_txt = itemView.findViewById(R.id.book_pages9_txt);
            book_pages10_txt = itemView.findViewById(R.id.book_pages10_txt);
            book_pages11_txt = itemView.findViewById(R.id.book_pages11_txt);
            book_pages12_txt = itemView.findViewById(R.id.book_pages12_txt);
            book_pages13_txt = itemView.findViewById(R.id.book_pages13_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
