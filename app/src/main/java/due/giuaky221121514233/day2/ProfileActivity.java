package due.giuaky221121514233.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;
import due.giuaky221121514233.day1.MainActivity;


public class ProfileActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvUser;
    private Button btEdit;
    private static final int REQUEST_CODE = 1;

    @Override
    protected int getLayoutResource() {
        return R.layout.day2_activity_profile;  // Thay thế bằng layout của ProfileActivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tvUser = (TextView) findViewById(R.id.tvName);
        btEdit = (Button) findViewById(R.id.btEdit);
        btEdit.setOnClickListener(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");
        tvUser.setText(username);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btEdit){
            onEdit();
        }
    }

    private void onEdit() {
        Intent intent = new Intent(this, EditUserActivity.class);
        intent.putExtra("USER_NAME", tvUser.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("RESULT");
                tvUser.setText(result);
            }
        }
    }
}