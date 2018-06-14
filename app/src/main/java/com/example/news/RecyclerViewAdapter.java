package com.example.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виталина on 19.08.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    List<Article> articles;
    LayoutInflater inflater;

    public RecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        articles = new ArrayList<>(); //список пустий але ініціалізований
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder holder = new RecyclerViewHolder(inflater.inflate(R.layout.recycler_item,parent,false)) ;
        return holder;//створили новий холдер і зв'язали із одним айтемом з xml файлу
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewHolder viewHolder = (RecyclerViewHolder) holder;
        viewHolder.bind(articles.get(position), position,this);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onClick(View v) {
        int pos = (int) v.getTag();
        Toast.makeText(v.getContext(),"Congratulations! " + pos,Toast.LENGTH_LONG).show();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }
}
