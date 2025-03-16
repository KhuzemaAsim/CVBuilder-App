package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ReferencesActivity extends AppCompatActivity {
    EditText etReferences;
    Button btnSaveReferences, btnCancelReferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references);

        etReferences = findViewById(R.id.etReferences);
        btnSaveReferences = findViewById(R.id.btnSaveReferences);
        btnCancelReferences = findViewById(R.id.btnCancelReferences);

        btnSaveReferences.setOnClickListener(v ->
        {
            String references = etReferences.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("references", references);
            setResult(RESULT_OK, resultIntent);
            finish();
        });


        btnCancelReferences.setOnClickListener(v ->
        {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
