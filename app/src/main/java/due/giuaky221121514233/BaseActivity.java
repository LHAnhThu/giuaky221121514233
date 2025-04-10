package due.giuaky221121514233;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import due.giuaky221121514233.day1.MainActivity;
import due.giuaky221121514233.day1.MaytinhActivity;
import due.giuaky221121514233.day2.DanhBaActivity;
import due.giuaky221121514233.day2.DanhBaListViewActivity;
import due.giuaky221121514233.day2.LoginActivity;
import due.giuaky221121514233.day3.ListNewsActivity;
import due.giuaky221121514233.day3.Main1Activity;
import due.giuaky221121514233.day3.activity.Weather_MainActivity;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    protected abstract int getLayoutResource();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_day1_main) {
            startActivity(new Intent(this, MainActivity.class));
        } else if (id == R.id.nav_day1_maytinh) {
            startActivity(new Intent(this, MaytinhActivity.class));
        } else if (id == R.id.nav_day2_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_day2_danhba_list) {
            startActivity(new Intent(this, DanhBaListViewActivity.class));
        } else if (id == R.id.nav_day2_danhba) {
            startActivity(new Intent(this, DanhBaActivity.class));
        } else if (id == R.id.nav_day3_main) {
            startActivity(new Intent(this, Main1Activity.class));
        } else if (id == R.id.nav_day3_listnews) {
            startActivity(new Intent(this, ListNewsActivity.class));
        } else if (id == R.id.nav_day3_weather) {
            startActivity(new Intent(this, Weather_MainActivity.class));
        }
        drawerLayout.closeDrawers();
        return true;
    }
}

