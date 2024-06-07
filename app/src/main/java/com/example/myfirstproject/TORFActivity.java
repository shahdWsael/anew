package com.example.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TORFActivity extends AppCompatActivity {
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_torfactivity);

        Button checkButton = findViewById(R.id.button7);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the checkboxes
                CheckBox checkBox1 = findViewById(R.id.checkbox1);
                CheckBox checkBox2 = findViewById(R.id.checkbox2);
                CheckBox checkBox3 = findViewById(R.id.checkbox3);

                // Get the checked state of the checkboxes
                boolean answer1 = checkBox1.isChecked(); // Correct answer is True
                boolean answer2 = checkBox2.isChecked(); // Correct answer is False
                boolean answer3 = !checkBox3.isChecked(); // Correct answer is True

                // Calculate the score
                int score = 0;
                if (answer1) score++;
                if (answer2) score++;
                if (answer3) score++;

                // Display the result in a Toast message
                Toast.makeText(TORFActivity.this, "Your score: " + score + " out of 3", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TORFActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
