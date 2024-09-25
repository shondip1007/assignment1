package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    //change 1git
    // change 2

    private Button btnText,btnImage,btnCheckRadio,btnSeekSwitchRatting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        btnText = findViewById(R.id.btntext);
        btnImage = findViewById(R.id.btnimage);
        btnCheckRadio = findViewById(R.id.btnCheckRadio);

        btnSeekSwitchRatting = findViewById(R.id.btnSeekbarRatingBarSwitch);

        btnText.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btnImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        });
        btnCheckRadio.setOnClickListener(v -> {
            Intent intent = new Intent(this, check_box_radio_button.class);
            startActivity(intent);
        });
        btnSeekSwitchRatting.setOnClickListener(v -> {
            Intent intent = new Intent(this, seekBar.class);
            startActivity(intent);
        });
    }
}