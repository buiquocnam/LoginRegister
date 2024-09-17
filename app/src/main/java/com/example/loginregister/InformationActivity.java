package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InformationActivity extends AppCompatActivity {

    private EditText infUser;
    private EditText infPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        infUser = findViewById(R.id.infUser);
        infPass = findViewById(R.id.infPass);

        Button btn1 = findViewById(R.id.btnLogin);
        Button btn2 = findViewById(R.id.btnRegister);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InformationActivity.this, LoginActivity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InformationActivity.this, RegisterActivity.class));
            }
        });


        String reccivedPass = getIntent().getStringExtra("text_pass");
        String reccivedUser = getIntent().getStringExtra("text_user");

        infUser.setText(reccivedUser);
        infPass.setText((reccivedPass));
    }
}