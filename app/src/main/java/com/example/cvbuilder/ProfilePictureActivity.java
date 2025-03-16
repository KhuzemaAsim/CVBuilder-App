package com.example.cvbuilder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilePictureActivity extends AppCompatActivity {
    ImageView ivProfile;
    Button btnSelect, btnSave, btnCancel;
    Uri imageUri;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_picture);

        init();
         //when select image button is clicked it will request an image from gallery and flag is set to give it access
        //to extract image from external source.
        btnSelect.setOnClickListener(v ->
        {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        btnSave.setOnClickListener(v ->
        {
            if (imageUri != null)
            {
                Intent intent = new Intent();
                intent.putExtra("profileImageUri", imageUri.toString());
                setResult(RESULT_OK, intent);
            }
            finish();
        });

        btnCancel.setOnClickListener(v ->
        {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
    private void init()
    {
        ivProfile = findViewById(R.id.imageViewProfile);
        btnSelect = findViewById(R.id.btnSelectImage);
        btnSave = findViewById(R.id.btnSaveImage);
        btnCancel = findViewById(R.id.btnCancelImage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null)
        {
            imageUri = data.getData();

            if (imageUri != null)
            {
                // Taking persistable URI permission
                getContentResolver().takePersistableUriPermission(imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                ivProfile.setImageURI(imageUri);
            }
        }
    }
}