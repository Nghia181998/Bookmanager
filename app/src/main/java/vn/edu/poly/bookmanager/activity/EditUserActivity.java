package vn.edu.poly.bookmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import vn.edu.poly.bookmanager.R;
import vn.edu.poly.bookmanager.adapter.UserAdapter;
import vn.edu.poly.bookmanager.database.DatabaseHelper;
import vn.edu.poly.bookmanager.model.User;

public class EditUserActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private UserAdapter adapter;
    private EditText name,phone;
    private Button edituser;
    private List<User> list;
    private Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        edituser=findViewById(R.id.btnedituser);
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("key");
        final String username=bundle.getString("username");
        initView();
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
                startActivity(intent);
            }
        });
        edituser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().matches("")){
                    name.setError("Bạn chưa nhập tên");
                }
                if(phone.getText().toString().matches("")){
                    phone.setError("Bạn chưa nhập số điện thoại");
                }
                User user=new User();
                user.setName(name.getText().toString());
                user.setPhone_number(phone.getText().toString());
                databaseHelper.updateUser(username,user);
                Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initView(){
        databaseHelper=new DatabaseHelper(this);
        name=findViewById(R.id.edtNameEdit);
        phone=findViewById(R.id.edtPhoneNumberEdit);
        toolbar1 = findViewById(R.id.tool0);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_white_18dp);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
