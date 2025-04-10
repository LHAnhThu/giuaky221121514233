package due.giuaky221121514233.day2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;
import due.giuaky221121514233.day1.MainActivity;


public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private EditText edUser;
    private EditText edPasswork;
    private Button btLogin;

    @Override
    protected int getLayoutResource() {
        return R.layout.day2_activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        edUser = (EditText)findViewById(R.id.edUser);
        edPasswork = (EditText)findViewById(R.id.edPassword);
        btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btLogin){
            onLogin();
        }
    }

    private void onLogin(){
        if (edUser.getText().toString().isEmpty() || edPasswork.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn chưa nhập user hoặc pasword", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("USER_NAME", edUser.getText().toString());
            startActivity(intent);
        }
    }


}