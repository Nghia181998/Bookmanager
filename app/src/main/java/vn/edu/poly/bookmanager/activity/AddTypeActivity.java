package vn.edu.poly.bookmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import vn.edu.poly.bookmanager.R;
public class AddTypeActivity extends AppCompatActivity {

    private Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_book);
        toolbar1 = findViewById(R.id.tool7);
        setSupportActionBar(toolbar1);
        toolbar1.setNavigationIcon(R.drawable.baseline_arrow_back_white_18dp);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TypeBookManagerMainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void themloai(View view) {
        Intent intent=new Intent(getApplicationContext(),TypeBookManagerMainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Thêm loại sách thành công", Toast.LENGTH_SHORT).show();
    }

    public void huyloai(View view) {
        Intent intent=new Intent(getApplicationContext(),TypeBookManagerMainActivity.class);
        startActivity(intent);
    }
}
