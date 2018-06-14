package com.example.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.LinearLayout;

import com.baoyz.widget.PullRefreshLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView news_recycler = (RecyclerView) findViewById(R.id.news_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        news_recycler.setLayoutManager(manager);

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(this);
        news_recycler.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final String api_key = getString(R.string.key);

        final INews_Api api = retrofit.create(INews_Api.class);

        Call<NewsResponse> call = api.getNews("cnn",api_key);
        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse newsResponse = response.body();
                adapter.setArticles(newsResponse.getArticles());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });

        //final PullRefreshLayout layout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);

// listen refresh event
        /*layout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Call<NewsResponse> call = api.getNews("cnn",api_key);
                call.enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        NewsResponse newsResponse = response.body();
                        adapter.setArticles(newsResponse.getArticles());
                      //  layout.setRefreshing(false);
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {

                    }
                });

            }
        });*/

// refresh complete


    }
}
