package com.example.cvbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CertificationsActivity extends AppCompatActivity {

    EditText etCertifications;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);

        etCertifications = findViewById(R.id.etCertifications);
        btnSave = findViewById(R.id.btnSaveCertifications);
        btnCancel = findViewById(R.id.btnCancelCertifications);

        btnSave.setOnClickListener(v ->
        {
            String certifications = etCertifications.getText().toString().trim();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("certifications", certifications);
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
