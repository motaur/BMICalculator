package com.example.room53.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView6);
        textView.setText("BMI: " + String.format("%.2f", MainActivity.getBmi()) + "\nWeight status: " + MainActivity.getWeightStatus() +"\nYour ideal weight is: " + String.format("%.2f", MainActivity.getIdealWeight()) + " kg \nYour weight is: " + String.format("%.2f", MainActivity.getWeight()) + " kg");
    }

}
