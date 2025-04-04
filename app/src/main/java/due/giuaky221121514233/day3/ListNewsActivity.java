package due.giuaky221121514233.day3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;
import due.giuaky221121514233.day1.MainActivity;
import due.giuaky221121514233.day3.adapter.NewsAdapter;
import due.giuaky221121514233.day3.model.Item;
import due.giuaky221121514233.day3.network.APIManager;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListNewsActivity extends BaseActivity {
    RecyclerView rvListNews;
    List<Item> listData;
    NewsAdapter adapter;
    APIManager service;

    @Override
    protected int getLayoutResource() {
        return R.layout.day3_activity_list_news;  // Thay thế bằng layout của ProfileActivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listData = new ArrayList<>();
        adapter = new NewsAdapter(ListNewsActivity.this, listData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        rvListNews = findViewById(R.id.rvListNews);
        rvListNews.setLayoutManager(layoutManager);
        rvListNews.setAdapter(adapter);

        setupRetrofit();
        getListData();

    }

    private void setupRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("X-RapidAPI-Host", "imdb236.p.rapidapi.com")
                                .header("X-RapidAPI-Key", "a414efd702msh19f1b81310a4fc3p1e54bfjsn1ba92e9716ba") // Thay API Key đúng của bạn
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(APIManager.class);
    }
    private void getListData() {
        service.getListData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, retrofit2.Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    listData.clear();
                    listData.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ListNewsActivity.this, "Lỗi dữ liệu!", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Toast.makeText(ListNewsActivity.this, "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }
}