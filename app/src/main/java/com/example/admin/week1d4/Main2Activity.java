package com.example.admin.week1d4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private SeekBar getSeekbar;
    private TextView showProgress;
    double amountProgress =0;
    double monthProgress =0;
    private SeekBar getMonthSeek;
    private TextView showMonthProgress;
    private EditText percentageVal;
    private TextView showResult;
    private EditText percentageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSeekbar = findViewById(R.id.seekbarId);
        showProgress = findViewById(R.id.trackSeekBar);
        getMonthSeek = findViewById(R.id.seekbarMonth);
        showMonthProgress = findViewById(R.id.trackMonth);
        percentageVal = findViewById(R.id.percentageId);

        showProgress.setText("You loan amount is : $"+amountProgress);
        showMonthProgress.setText("Month : "+amountProgress);

        // perform seek bar change listener event used for getting the progress value
        getSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                amountProgress = i;
                //Toast.makeText(getApplicationContext(),"Value is ready to change", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showProgress.setText("You loan amount is : $"+amountProgress);
                Toast.makeText(getApplicationContext(),"Your value is "+amountProgress,Toast.LENGTH_SHORT).show();
            }
        });

        getMonthSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                monthProgress=i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showMonthProgress.setText("Month : "+monthProgress);
                Toast.makeText(getApplicationContext(),"Your value is "+monthProgress,Toast.LENGTH_SHORT).show();
            }
        });


    }
//    public static double CalculateEmi(double prinicipalAmount, double interestRate, int numberOfIns){
//
//        double interestrate = interestRate/(12*100);
//
//        double result = prinicipalAmount*interestrate*Math.pow(1+interestrate,numberOfIns)/Math.pow(1+interestrate,numberOfIns-1);
//
//        return result;
//    }

    public void calculateEmi(View view) {
        showResult = findViewById(R.id.showResult);
        percentageId = findViewById(R.id.percentageId);
        String percentage = percentageId.getText().toString();
        double pertenctageDb = Double.parseDouble(percentage);

        double interestrate = pertenctageDb/(12*100);
        double result = amountProgress*interestrate*Math.pow(1+interestrate,monthProgress)/Math.pow(1+interestrate,monthProgress-1);
        String strResult = Double.toString(result);
        showResult.setText(strResult);

    }

    public void goPersonAct(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }
}
