package due.giuaky221121514233.day2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

import due.giuaky221121514233.BaseActivity;
import due.giuaky221121514233.NavActivity;
import due.giuaky221121514233.R;
import due.giuaky221121514233.day1.MainActivity;

public class DanhBaListViewActivity extends BaseActivity implements IOnChildItemClick {
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected int getLayoutResource() {
        return R.layout.day2_activity_danh_ba_list_view; // Trả về layout của MainActivity
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContact, true);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(DanhBaListViewActivity.this, model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView () {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        listContact.add(new ContactModel("Trần Trường Sơn", "0988111222", R.drawable.user1));
        listContact.add(new ContactModel("Trần Thị Bình", "0988111333", R.drawable.user2));
        listContact.add(new ContactModel("Hồ Văn Dũng", "0988111555", R.drawable.user3));
        listContact.add(new ContactModel("Đào Thị Mơ", "0988222333", R.drawable.user3));
        listContact.add(new ContactModel("Ngô Thị Mận", "0988555222", R.drawable.user1));
        listContact.add(new ContactModel("Nguyễn Quang Tèo", "0988666111", R.drawable.user2));
        listContact.add(new ContactModel("Giang Văn Còi", "0988056789", R.drawable.user2));
        listContact.add(new ContactModel("Ngô Văn Ngố", "0988056789", R.drawable.user1));
        listContact.add(new ContactModel("Phùng A Chải", "0988056789", R.drawable.user1));
        listContact.add(new ContactModel("Đinh Thị Định", "0988056789", R.drawable.user3));
        listContact.add(new ContactModel("Lỗ Văn Lấp", "0988056789", R.drawable.user3));
        listContact.add(new ContactModel("Hâm Văn Hấp", "0988056789", R.drawable.user2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}