package com.example.myfirstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MultiActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;

    private Button checkButton;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        radioGroup1 = findViewById(R.id.R1);
        radioGroup2 = findViewById(R.id.R2);
        radioGroup3 = findViewById(R.id.R3);

        checkButton = findViewById(R.id.check_button);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }

        });
      back=findViewById(R.id.back);
      back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MultiActivity.this, QuizActivity.class);
              startActivity(intent);
          }
      });
        // Set only one option selectable in each RadioGroup
        setSingleOptionSelection(radioGroup1);
        setSingleOptionSelection(radioGroup2);
        setSingleOptionSelection(radioGroup3);
    }


    private void setSingleOptionSelection(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    for (int i = 0; i < group.getChildCount(); i++) {
                        RadioButton radioButton = (RadioButton) group.getChildAt(i);
                        radioButton.setEnabled(radioButton.getId() == checkedId);
                    }
                }
            }
        });
    }

    private void checkAnswers() {
        int score = 0;
        StringBuilder wrongAnswers = new StringBuilder();

        if (radioGroup1.getCheckedRadioButtonId() == R.id.btn3) {
            score++;
        } else {
            wrongAnswers.append("Question 1\n");
        }

        if (radioGroup2.getCheckedRadioButtonId() == R.id.radioButton6) {
            score++;
        } else {
            wrongAnswers.append("Question 2\n");
        }

        if (radioGroup3.getCheckedRadioButtonId() == R.id.radioButton9) {
            score++;
        } else {
            wrongAnswers.append("Question 3\n");
        }

        String resultMessage = "Score: " + score + " out of 3\n";

        if (score < 3) {
            resultMessage += "Incorrect answers:\n" + wrongAnswers.toString();
        }

        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
    }
}
