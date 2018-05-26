package com.example.room53.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity
{
    //views
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button submitButton;
    private SeekBar ageSeek;
    private TextView ageValue;
    private SeekBar weightSeek;
    private TextView weightValue;
    private SeekBar heightSeek;
    private TextView heightValue;
    private Spinner bodySpinner;


    private String body;
    private String gender;
    private double height = 130;
    private int age = 10;

    private static double weight = 40;

    private static double idealWeight;
    private static double bmi;
    private static String weightStatus;
    private double slimness;

    public static double getWeight() {return weight;}

    public static double getIdealWeight() {
        return idealWeight;
    }

    public static double getBmi() {
        return bmi;
    }

    public static String getWeightStatus() {
        return weightStatus;
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void initViews()
    {
        submitButton = (Button) findViewById(R.id.submit);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioSexGroup.check(R.id.male); //male checked by default

        //init seek Bar for height
        heightValue = (TextView) findViewById(R.id.height_value);
        heightSeek = (SeekBar) findViewById(R.id.seekBar);
        heightSeek.setMax(100);
        heightSeek.setProgress(0);
        heightValue.setText("" + height + " cm");
        heightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser )
            {
                height = progress + 130;
                heightValue.setText("" + height + " cm");

            }

            @Override
            public void onStartTrackingTouch( SeekBar seekBar ) {  }

            @Override
            public void onStopTrackingTouch( SeekBar seekBar ) {   }
        });

        //weight seek bar init
        weightValue = (TextView) findViewById(R.id.weight_value);
        weightSeek = (SeekBar) findViewById(R.id.seekBar2);
        weightSeek.setMax(100);
        weightSeek.setProgress(0);
        weightValue.setText("" + weight + " kg");
        weightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser )
            {
                weight = progress + 40;
                weightValue.setText("" + weight + " kg");
            }

            @Override
            public void onStartTrackingTouch( SeekBar seekBar ) {  }

            @Override
            public void onStopTrackingTouch( SeekBar seekBar ) {   }
        });

        //age seek bar init
        ageValue = (TextView) findViewById(R.id.age_value);
        ageSeek = (SeekBar) findViewById(R.id.seekBar3);
        ageSeek.setMax(80);
        ageSeek.setProgress(0);
        ageValue.setText("" + age + " years");
        ageSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {

            @Override
            public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser )
            {
                age = progress + 10;
                ageValue.setText("" + age + " years");
            }

            @Override
            public void onStartTrackingTouch( SeekBar seekBar ) {  }

            @Override
            public void onStopTrackingTouch( SeekBar seekBar ) {   }
        });

        //spinner init
        bodySpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.body_frame, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bodySpinner.setAdapter(adapter);

    }

    //on pressed "submit" button
    public void submit( View view )
    {
            //get data from radio button
            radioSexButton = (RadioButton) findViewById(radioSexGroup.getCheckedRadioButtonId());
            gender = (String) radioSexButton.getText();

            //get data from spinner
            body = (String) bodySpinner.getSelectedItem();

            calculate();

        Intent intent = new Intent(this, DisplayData.class);
        startActivity(intent);

    }

    private void calculate()
    {
        //bmi
        Log.v("weight" + weight, "height" + height);
        bmi = weight / Math.pow(2, height * 0.01);

        //weight status
        if(bmi < 15)
            weightStatus = "Anorexic";
        else if(bmi >= 15 && bmi < 18.5)
            weightStatus = "Underweight";
        else if(bmi >= 18.5 && bmi < 24.9)
            weightStatus = "Normal";
        else if(bmi >= 24.9 && bmi < 29.9 )
            weightStatus = "Overweight";
        else if(bmi >= 29.9 && bmi < 35 )
            weightStatus = "Obese";
        else if(bmi >= 35)
            weightStatus = "Extreme Obese";

        //slimness
        switch(body)
        {
            case "Small":
                slimness = 1;
                break;
            case "Medium":
                slimness = 1.27;
                break;
            case "Large":
                slimness = 1.45;
                break;

        }

        //ideal weight
        if(gender.equals("Male"))
            idealWeight = (height - 100 + (age * 0.1)) * 0.9 * slimness;
        else
            idealWeight = (height - 110 + (age * 0.1)) * 0.85 * slimness;
    }
}
