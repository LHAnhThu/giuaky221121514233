package due.giuaky221121514233.day3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;
import due.giuaky221121514233.day3.model.Item;
import due.giuaky221121514233.day3.network.APIManager;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main1Activity extends BaseActivity {
    TextView tvDate, tvTitle, tvContent;
    ImageView ivCover;
    APIManager service;

    @Override
    protected int getLayoutResource() {
        return R.layout.day3_activity_main1;  // Thay thế bằng layout của ProfileActivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvTitle = findViewById(R.id.tvTitle);
        tvContent = findViewById(R.id.tvContent);
        tvDate = findViewById(R.id.tvDate);
        ivCover = findViewById(R.id.ivCover);

        setupRetrofit();
        getData();

    }

    private void setupRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .header("X-RapidAPI-Host", "imdb236.p.rapidapi.com")
                                .header("X-RapidAPI-Key", "a414efd702msh19f1b81310a4fc3p1e54bfjsn1ba92e9716ba")
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

    private void getData() {
        service.getItemData().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, retrofit2.Response<List<Item>> response) {
                if (!response.isSuccessful() || response.body() == null || response.body().isEmpty()) {
                    Log.d("Main2Activity", "No data received");
                    Toast.makeText(Main1Activity.this, "Lỗi dữ liệu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lấy item đầu tiên
                Item model = response.body().get(0);
                tvTitle.setText(model.getTitle());
                tvDate.setText(model.getDate());
                tvContent.setText(model.getContent());
                Glide.with(Main1Activity.this).load(model.getImage()).into(ivCover);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("Main2Activity", "onFailure: " + t.getMessage());
                Toast.makeText(Main1Activity.this, "Kết nối thất bại!", Toast.LENGTH_LONG).show();
            }
        });
    }
}