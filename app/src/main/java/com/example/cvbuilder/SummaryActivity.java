package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {
    EditText etSummary;
    Button btnSaveSummary, btnCancelSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        etSummary = findViewById(R.id.etSummary);
        btnSaveSummary = findViewById(R.id.btnSaveSummary);
        btnCancelSummary = findViewById(R.id.btnCancelSummary);

        btnSaveSummary.setOnClickListener(v ->
        {
            String summaryText = etSummary.getText().toString().trim();
            Intent intent = new Intent();
            intent.putExtra("summary", summaryText);
            setResult(RESULT_OK, intent);
            finish();
        });

        btnCancelSummary.setOnClickListener(v ->
        {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
