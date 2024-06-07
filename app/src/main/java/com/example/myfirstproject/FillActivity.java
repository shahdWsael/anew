package com.example.myfirstproject;

import android.content.Intent;
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

public class FillActivity extends AppCompatActivity {
    // Define the correct answers for each question

    private final String[] correctAnswers = {"28", "42", "36", "27"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        EditText editText1 = findViewById(R.id.editTextText);
        EditText editText2 = findViewById(R.id.editTextText2);
        EditText editText3 = findViewById(R.id.editTextText3);
        EditText editText4 = findViewById(R.id.editTextText4);
        Button submitButton = findViewById(R.id.submit);


        // Set click listener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user's answers
                String answer1 = editText1.getText().toString().trim();
                String answer2 = editText2.getText().toString().trim();
                String answer3 = editText3.getText().toString().trim();
                String answer4 = editText4.getText().toString().trim();

                // Check answers and calculate score
                int score = calculateScore(answer1, answer2, answer3, answer4);

                // Display score in a Toast message
                Toast.makeText(FillActivity.this, "Your score: " + score + "/4", Toast.LENGTH_SHORT).show();
            }

        });

      Button backButton=findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FillActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }

    // Method to calculate score based on user's answers
    private int calculateScore(String... answers) {
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (answers[i].equals(correctAnswers[i])) {
                score++;
            }
        }
        return score;
    }


}