package due.giuaky221121514233;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import due.giuaky221121514233.databinding.ActivityNavBinding;
import due.giuaky221121514233.day1.MainActivity;
import due.giuaky221121514233.day1.MaytinhActivity;
import due.giuaky221121514233.day2.DanhBaActivity;
import due.giuaky221121514233.day2.DanhBaListViewActivity;
import due.giuaky221121514233.day2.LoginActivity;
import due.giuaky221121514233.day3.ListNewsActivity;
import due.giuaky221121514233.day3.Main1Activity;
import due.giuaky221121514233.day3.activity.Weather_MainActivity;

public class NavActivity extends AppCompatActivity {
private ActivityNavBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập toolbar
        setSupportActionBar(binding.appBarNav.toolbar);

        // Kích hoạt nút "Up" (nút quay lại) trên thanh công cụ
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); // Hiển thị nút quay lại
        }

        // Kết nối DrawerLayout và NavigationView
        DrawerLayout drawer = binding.drawerLayout;

        // Kết nối với ActionBarDrawerToggle để thanh điều hướng hoạt động
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.appBarNav.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Cài đặt mục tiêu các hoạt động từ menu
        binding.navView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            Intent intent = null;

            if (id == R.id.nav_day1_main) {
                intent = new Intent(this, MainActivity.class);
            } else if (id == R.id.nav_day1_maytinh) {
                intent = new Intent(this, MaytinhActivity.class);
            } else if (id == R.id.nav_day2_login) {
                intent = new Intent(this, LoginActivity.class);
            } else if (id == R.id.nav_day2_danhba_list) {
                intent = new Intent(this, DanhBaListViewActivity.class);
            } else if (id == R.id.nav_day2_danhba) {
                intent = new Intent(this, DanhBaActivity.class);
            } else if (id == R.id.nav_day3_listnews) {
                intent = new Intent(this, ListNewsActivity.class);
            } else if (id == R.id.nav_day3_main) {
                intent = new Intent(this, Main1Activity.class);
            } else if (id == R.id.nav_day3_weather) {
                intent = new Intent(this, Weather_MainActivity.class);
            }

            if (intent != null) {
                startActivity(intent);
                drawer.closeDrawer(GravityCompat.START);  // Đóng Drawer sau khi chuyển Activity
                return true;
            }

            return false;
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

}