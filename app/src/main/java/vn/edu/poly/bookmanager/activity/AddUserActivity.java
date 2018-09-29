package vn.edu.poly.bookmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import vn.edu.poly.bookmanager.R;
import vn.edu.poly.bookmanager.adapter.UserAdapter;
import vn.edu.poly.bookmanager.database.DatabaseHelper;
import vn.edu.poly.bookmanager.model.User;

public class AddUserActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private UserAdapter adapter;
    private Button adduser;
    private List<User> list;
    public EditText userName,name,passWord,rePass,phoneNumber;
    private Toolbar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        initView();
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
                startActivity(intent);
            }
        });
        adduser=findViewById(R.id.btnadduser);
        adduser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().matches("")){
                    userName.setError("Bạn chưa nhập User Name");
                }
                if(name.getText().toString().matches("")){
                    name.setError("Bạn chưa nhập Name");
                }
                if(passWord.getText().toString().matches("")){
                    passWord.setError("Bạn chưa nhập Password");
                }
                if(rePass.getText().toString().matches("")){
                    rePass.setError("Bạn chưa nhập lại Password");
                }
                if(phoneNumber.getText().toString().matches("")){
                    phoneNumber.setError("Bạn chưa nhập số điện thoại");
                }
                if (passWord.getText().toString().matches(rePass.getText().toString())){
                databaseHelper=new DatabaseHelper(getApplicationContext());
                String uname=userName.getText().toString();
                String name_=name.getText().toString();
                String phone=phoneNumber.getText().toString();
                String pass=passWord.getText().toString();
                User user4=new User(uname,name_,phone,pass);
                databaseHelper.insertUser(user4);
                Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Thêm user thành công", Toast.LENGTH_SHORT).show();
            }else {
                    passWord.setError("Password chưa trùng nhau");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void huytk(View view) {
        Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
        startActivity(intent);
    }
    public void initView(){

        userName=findViewById(R.id.edtUserName);
        name=findViewById(R.id.edtName);
        passWord=findViewById(R.id.edtPassWord);
        rePass=findViewById(R.id.edtRepass);
        phoneNumber=findViewById(R.id.edtPhoneNumber);
        toolbar1 = findViewById(R.id.tool9);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_white_18dp);

    }
}
