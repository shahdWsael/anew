package com.example.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    Button btnMulti;
    Button btnTOF;
    Button btnFill;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ListView listView = findViewById(R.id.listView);
        List<String> list = new ArrayList<>();
        list.add("Multiple choice");
        list.add("True Or False");
        list.add("Fill the balnk");
        list.add("Back ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        // Set item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click based on position
                switch (position) {
                    case 0:
                        // Start Multiple Choice activity
                        startActivity(new Intent(QuizActivity.this, MultiActivity.class));
                        break;
                    case 1:
                        // Start True Or False activity
                        startActivity(new Intent(QuizActivity.this, TORFActivity.class));
                        break;
                    case 2:
                        // Start Fill the Blank activity
                        startActivity(new Intent(QuizActivity.this, FillActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(QuizActivity.this, WelcomeActivity.class));
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
