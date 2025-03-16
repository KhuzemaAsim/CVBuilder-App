package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {
    EditText etExperience;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        etExperience = findViewById(R.id.etExperience);
        btnSave = findViewById(R.id.btnSaveExperience);
        btnCancel = findViewById(R.id.btnCancelExperience);

        btnSave.setOnClickListener(v ->
        {
            String experienceText = etExperience.getText().toString().trim();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("experience", experienceText);
            setResult(RESULT_OK, resultIntent);
            finish();
        });


        btnCancel.setOnClickListener(v ->
        {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
