package com.example.adityakhandelwal.findfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {


    TextView city;
    Button add;
    Button explore;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        city = (TextView)findViewById(R.id.textView2);
        explore = (Button)findViewById(R.id.explore);
        add = (Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(HomeActivity.this , add.class);
                startActivity(addIntent);
                finish();
            }
        });


    }
}
