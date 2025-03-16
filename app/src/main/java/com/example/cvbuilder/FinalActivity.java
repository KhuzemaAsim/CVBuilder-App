package com.example.cvbuilder;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {
    ImageView ivFinalProfile;
    TextView UserName,Email,ContactNumber,Summary,Education,Experience,Certifications,References;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        ivFinalProfile = findViewById(R.id.ivFinalProfile);
        UserName=findViewById(R.id.tvFullName);
        Email=findViewById(R.id.tvEmail);
        ContactNumber=findViewById(R.id.tvPhone);
        Summary=findViewById(R.id.tvSummary);
        Education=findViewById(R.id.tvEducation);
        Experience=findViewById(R.id.tvExperience);
        Certifications=findViewById(R.id.tvCertifications);
        References=findViewById(R.id.tvReferences);

        String imageUriString = getIntent().getStringExtra("profileImageUri");
        String name=getIntent().getStringExtra("name");
        String em=getIntent().getStringExtra("email");
        String phoneNum=getIntent().getStringExtra("contact");
        String Summ=getIntent().getStringExtra("summary");
        String edu=getIntent().getStringExtra("education");
        String ex=getIntent().getStringExtra("experience");
        String cert=getIntent().getStringExtra("certifications");
        String ref=getIntent().getStringExtra("references");

        if (imageUriString != null && !imageUriString.isEmpty())
        {
            Uri imageUri = Uri.parse(imageUriString);
            ivFinalProfile.setImageURI(imageUri);
        }
        else
        {
            Toast.makeText(this, "No profile image received!", Toast.LENGTH_SHORT).show();
        }

        if (name != null && !name.isEmpty())
        {
            UserName.setText(name);
        }
        if (em != null && !em.isEmpty())
        {
            Email.setText(em);
        }
        if (phoneNum != null && !phoneNum.isEmpty())
        {
            ContactNumber.setText(phoneNum);
        }
        if (Summ != null && !Summ.isEmpty())
        {
            Summary.setText(Summ);
        }
        if (edu != null && !edu.isEmpty())
        {
            Education.setText(edu);
        }
        if (ex != null && !ex.isEmpty())
        {
            Experience.setText(ex);
        }
        if (cert != null && !cert.isEmpty())
        {
            Certifications.setText(cert);
        }
        if (ref!= null && !ref.isEmpty())
        {
            References.setText(ref);
        }
    }
}
