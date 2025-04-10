package due.giuaky221121514233;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
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

        setSupportActionBar(binding.appBarNav.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        DrawerLayout drawer = binding.drawerLayout;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, binding.appBarNav.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            return false;
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

}