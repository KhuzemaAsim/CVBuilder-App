package com.example.cvbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageProfile;
    Button Profile_picture, Personal_Details, Summary, Education, Experience, Certifications, References, Preview;
    private String profileImageUri = null;
    private String userName = null, userEmail = null, userContact = null, userSummary=null, userEducation=null,userExperience=null,userCertifications=null,userReferences=null;

    private static final int PROFILE_PIC_REQUEST_CODE = 100;
    private static final int PERSONAL_DETAILS_REQUEST_CODE = 101;
    private static final int SUMMARY_REQUEST_CODE = 102;
    private static final int EDUCATION_REQUEST_CODE = 103;
    private static final int EXPERIENCE_REQUEST_CODE = 104;
    private static final int CERTIFICATIONS_REQUEST_CODE = 105;
    private static final int REFERENCES_REQUEST_CODE = 106;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imageProfile = findViewById(R.id.ivProfile_pic);
        Profile_picture = findViewById(R.id.btn_profile_pic);
        Personal_Details = findViewById(R.id.btn_personal_details);
        Summary = findViewById(R.id.btn_summary);
        Education = findViewById(R.id.btn_education);
        Experience = findViewById(R.id.btn_experience);
        Certifications = findViewById(R.id.btn_certifications);
        References = findViewById(R.id.btn_references);
        Preview = findViewById(R.id.preview_cv);

        //When button are clicked
        Profile_picture.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, ProfilePictureActivity.class);
            startActivityForResult(intent, PROFILE_PIC_REQUEST_CODE);
        });
        Personal_Details.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, PersonalDetailsActivity.class);
            startActivityForResult(intent, PERSONAL_DETAILS_REQUEST_CODE);
        });
        Summary.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            startActivityForResult(intent, SUMMARY_REQUEST_CODE);
        });
        Education.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, EducationActivity.class);
            startActivityForResult(intent, EDUCATION_REQUEST_CODE);
        });
        Experience.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, ExperienceActivity.class);
            startActivityForResult(intent, EXPERIENCE_REQUEST_CODE);
        });
        Certifications.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, CertificationsActivity.class);
            startActivityForResult(intent, CERTIFICATIONS_REQUEST_CODE);
        });
        References.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, ReferencesActivity.class);
            startActivityForResult(intent, REFERENCES_REQUEST_CODE);
        });
        Preview.setOnClickListener(v ->
        {
            Intent intent = new Intent(MainActivity.this, FinalActivity.class);
            intent.putExtra("profileImageUri", profileImageUri);
            intent.putExtra("name", userName);
            intent.putExtra("email", userEmail);
            intent.putExtra("contact", userContact);
            intent.putExtra("summary", userSummary);
            intent.putExtra("education",userEducation);
            intent.putExtra("experience",userExperience);
            intent.putExtra("certifications",userCertifications);
            intent.putExtra("references",userReferences);
            startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null)
        {
            if (requestCode == PROFILE_PIC_REQUEST_CODE) {
                profileImageUri = data.getStringExtra("profileImageUri");
                if (profileImageUri != null)
                {
                    imageProfile.setImageURI(Uri.parse(profileImageUri));
                }
            }
            else if (requestCode == PERSONAL_DETAILS_REQUEST_CODE)
            {
                userName = data.getStringExtra("name");
                userEmail = data.getStringExtra("email");
                userContact = data.getStringExtra("contact");
            }
            else if (requestCode == SUMMARY_REQUEST_CODE)
            {
                userSummary = data.getStringExtra("summary");
            }
            else if (requestCode == EDUCATION_REQUEST_CODE)
            {
                userEducation = data.getStringExtra("education");
            }
            else if (requestCode == EXPERIENCE_REQUEST_CODE)
            {
                userExperience = data.getStringExtra("experience");
            }

            else if (requestCode == CERTIFICATIONS_REQUEST_CODE)
            {
                userCertifications = data.getStringExtra("certifications");
            }
            else if (requestCode == REFERENCES_REQUEST_CODE)
            {
                userReferences = data.getStringExtra("references");
            }
        }
    }
}
