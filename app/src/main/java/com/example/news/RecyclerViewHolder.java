package com.example.news;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Виталина on 19.08.2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    CardView news_card_view;
    TextView news_title, news_description;
    ImageView news_image;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        news_card_view = (CardView) itemView.findViewById(R.id.news_card_view);
        news_title = (TextView) itemView.findViewById(R.id.news_title);
        news_description = (TextView) itemView.findViewById(R.id.news_description);
        news_image = (ImageView) itemView.findViewById(R.id.news_image);
    }

    public void bind(Article article,int position, View.OnClickListener listener){

        news_title.setText(article.getTitle());
        news_description.setText(article.getDescription().toString());
        Glide.with(news_card_view.getContext()).load(article.getUrlToImage()).into(news_image);
        news_card_view.setOnClickListener(listener);
        news_card_view.setTag(position);
    }
}
