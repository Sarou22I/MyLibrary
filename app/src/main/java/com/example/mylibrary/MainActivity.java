package com.example.mylibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText etPages = findViewById(R.id.etPages);
        EditText etAuthor = findViewById(R.id.etAuthor);
        EditText etBook = findViewById(R.id.etBook);
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pagesText = etPages.getText().toString();
                String BookText = etBook.getText().toString();
                String AuthorText = etAuthor.getText().toString();
                if (pagesText.isEmpty() ){
                    etPages.setError("please fill in the amount of pages");

                }
                if( BookText.isEmpty()){
                    etBook.setError("please fill in the books name");

                }
                if( AuthorText.isEmpty()){
                    etAuthor.setError("please fill in the books name");
                    return;
                }
                Toast.makeText(MainActivity.this,"Saved to cloud",Toast.LENGTH_SHORT).show();
            }
        });
    }
}