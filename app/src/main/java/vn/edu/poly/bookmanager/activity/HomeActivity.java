package vn.edu.poly.bookmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.edu.poly.bookmanager.R;

public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
    }

    public void dangxuat(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void usermanager(View view) {
        Intent intent = new Intent(getApplicationContext(), UserManagerActivity.class);
        startActivity(intent);
    }

    public void loaisach(View view) {
        Intent intent = new Intent(getApplicationContext(), TypeBookManagerMainActivity.class);
        startActivity(intent);
    }

    public void sach(View view) {
        Intent intent = new Intent(getApplicationContext(), BookManagerActivity.class);
        startActivity(intent);
    }

    public void hoadon(View view) {
        Intent intent = new Intent(getApplicationContext(), HoaDonActivity.class);
        startActivity(intent);
    }

    public void top10(View view) {
        Intent intent = new Intent(getApplicationContext(), Top10Activity.class);
        startActivity(intent);
    }

    public void thongke(View view) {
        Intent intent = new Intent(getApplicationContext(), ThongKeActivity.class);
        startActivity(intent);
    }
}
