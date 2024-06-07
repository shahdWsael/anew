package com.example.myfirstproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private boolean flag = false;
    public static final String FLAG = "FLAG";
    public static final String NAME = "NAME";
    public static final String PASS = "PASS";
    private EditText edtUser;
    private EditText edtPass;
    private Button btn;
    private CheckBox chk;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnLearn), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            edtUser=findViewById(R.id.edtUser);
            edtPass=findViewById(R.id.edtPass);
            btn=findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = edtUser.getText().toString();
                    String password = edtPass.getText().toString();
                    if(chk.isChecked()) {
                        if (!flag) {
                            editor.putString(NAME, name);
                            editor.putString(PASS, password);
                            editor.putBoolean(FLAG, true);
                            editor.commit();
                        }
                    }
                    if(edtUser.getText().toString().equals("user")&&edtPass.getText().toString().equals("1234")){
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login Faild", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            chk = findViewById(R.id.chk);
            prefs= PreferenceManager.getDefaultSharedPreferences(this);
            editor = prefs.edit();

            flag = prefs.getBoolean(FLAG, false);

            if(flag){
                String name = prefs.getString(NAME, "");
                String password = prefs.getString(PASS, "");
                edtUser.setText(name);
                edtPass.setText(password);
                chk.setChecked(true);
            }

            return insets;
        });
    }
}