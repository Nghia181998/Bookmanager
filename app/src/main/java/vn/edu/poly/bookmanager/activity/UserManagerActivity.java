package vn.edu.poly.bookmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.bookmanager.R;
import vn.edu.poly.bookmanager.adapter.UserAdapter;
import vn.edu.poly.bookmanager.database.DatabaseHelper;
import vn.edu.poly.bookmanager.model.User;

public class UserManagerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private UserAdapter adapter;
    private List<User> list;
    private RecyclerView recyclerView;
private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        recyclerView=findViewById(R.id.recycleUser);
        databaseHelper=new DatabaseHelper(this);
        list = new ArrayList<>();
        list = databaseHelper.getUserAll();
        adapter=new UserAdapter(this,list);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        toolbar = findViewById(R.id.tool1);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_white_18dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        adapter.setOnItemLongClickedListener(new UserAdapter.OnItemLongClickedListener() {
            @Override
            public void onItemLongClick(String username) {
                Toast.makeText(UserManagerActivity.this, username, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void themuser(View view) {
        Intent intent = new Intent(getApplicationContext(), AddUserActivity.class);
        startActivity(intent);
    }

}
