package due.giuaky221121514233.day1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.day1_activity_main; // Trả về layout của MainActivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
