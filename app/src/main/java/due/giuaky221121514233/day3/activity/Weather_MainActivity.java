package due.giuaky221121514233.day3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.day3.ListNewsActivity;
import due.giuaky221121514233.day3.adapter.HourAdapter;
import due.giuaky221121514233.day3.model.Weather;
import due.giuaky221121514233.day3.network.Weather_ApiManager;

import java.util.List;

import due.giuaky221121514233.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Weather_MainActivity extends BaseActivity {
    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvSatus;

    @Override
    protected int getLayoutResource() {
        return R.layout.day3_weather_activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        tvTem = (TextView) findViewById(R.id.tvTem);
        tvSatus = (TextView) findViewById(R.id.tvStatus);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvHour = (RecyclerView) findViewById(R.id.rvHour);
        rvHour.setLayoutManager(layoutManager);

        getHours();

    }

    private void getHours() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Weather_ApiManager.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Weather_ApiManager service = retrofit.create(Weather_ApiManager.class);
        service.gethour("353412", "tbFOLXfZmAxAexEYOmXhcxnbZBDjQBSh", "vi-vn", true).enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse (Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() == null) return;
                List<Weather> listWeather = response.body();
                HourAdapter adapter = new HourAdapter(Weather_MainActivity.this, listWeather);
                rvHour.setAdapter(adapter);

                Weather weather = listWeather.get(0);
                tvTem.setText(weather.getTemperature().getValue().intValue() + "°");
                tvSatus.setText(weather.getIconPhrase());
            }
            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {

            }
        });
    }
}