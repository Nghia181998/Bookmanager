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

public class ChangePasswordActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private UserAdapter adapter;
    private EditText pass,newpass;
    private Button btnchange;
    private List<User> list;
    private Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initView();
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("key");
        final String username=bundle.getString("username");
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), UserManagerActivity.class);
                startActivity(intent2);
            }
        });
        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().matches("")){
                    pass.setError("Nhập password");
                }
                if(newpass.getText().toString().matches("")){
                    newpass.setError("Nhập password mới");
                }
                User user1=databaseHelper.getUser(username);
                String password1=user1.getPassword();
                User user=new User();
                user.setPassword(newpass.getText().toString());
                if(password1.matches(pass.getText().toString().trim())) {
                    databaseHelper.changePassword(username, user);
                    Intent intent3=new Intent(getApplicationContext(),UserManagerActivity.class);
                    startActivity(intent3);
                }else {
                    pass.setError("Password chưa chính xác");
                }
            }
        });
    }
    public void initView(){
        databaseHelper=new DatabaseHelper(this);
        pass=findViewById(R.id.edtPassWordEdit);
        newpass=findViewById(R.id.edtNewpass);
        btnchange=findViewById(R.id.btnchangepassword);
        toolbar1 = findViewById(R.id.tooleditpassword);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_white_18dp);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
