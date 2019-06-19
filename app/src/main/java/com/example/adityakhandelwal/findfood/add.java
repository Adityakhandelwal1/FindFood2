package com.example.adityakhandelwal.findfood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class add extends AppCompatActivity {

    private static final int    PICK_IMAGE_REQUEST=1;

    private Button choosefile;
    private Button upload;
    private TextView showuploads;
    private EditText place;
    private ImageView display;
    private ProgressBar progressbar;

    private Uri mImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        choosefile = findViewById(R.id.choosefile);
        upload = findViewById(R.id.upload);
        showuploads = findViewById(R.id.showuploads);
        place = findViewById(R.id.place);
        display = findViewById(R.id.display);
        progressbar=findViewById(R.id.progressbar);

        choosefile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        showuploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== PICK_IMAGE_REQUEST && resultCode== RESULT_OK && data != null && data.getData() != null)
        {
            mImageUri = data.getData();
            display.setImageURI(mImageUri);
        }
    }

    public void ReturnHome(View view){
        Intent homeIntent = new Intent(add.this , HomeActivity.class);
        startActivity(homeIntent);
        finish();
    }
}
