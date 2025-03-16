package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {
    EditText etEducation;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        etEducation = findViewById(R.id.etEducation);
        btnSave = findViewById(R.id.btnSaveEducation);
        btnCancel = findViewById(R.id.btnCancelEducation);

        btnSave.setOnClickListener(v ->
        {
            String educationText = etEducation.getText().toString().trim();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("education", educationText);
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
