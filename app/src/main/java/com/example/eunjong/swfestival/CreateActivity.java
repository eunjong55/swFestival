package com.example.eunjong.swfestival;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CreateActivity extends AppCompatActivity {
    private ArrayAdapter yearAdapter;
    private Spinner yearSpinner;
    private ArrayAdapter termAdapter;
    private Spinner termSpinner;
    private ArrayAdapter areaAdapter;
    private Spinner areaSpinner;

    private String courseUniversity = "";
    private String courseYear = "";
    private String courseTerm = "";
    private String courseArea = "";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create);
        Intent intent = getIntent();



        final RadioGroup courseUniversityGroup = (RadioGroup) findViewById(R.id.courseUniversityGroup);
        yearSpinner = (Spinner) findViewById(R.id.yearSpinner);
        termSpinner = (Spinner) findViewById(R.id.termSpinner);
        areaSpinner = (Spinner) findViewById(R.id.areaSpinner);
        courseUniversityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton courseButton = (RadioButton) findViewById(i);
                courseUniversity = courseButton.getText().toString();

                yearAdapter = ArrayAdapter.createFromResource(CreateActivity.this, R.array.term, android.R.layout.simple_spinner_dropdown_item);
                yearSpinner.setAdapter(yearAdapter);

                termAdapter = ArrayAdapter.createFromResource(CreateActivity.this, R.array.graduateArea, android.R.layout.simple_spinner_dropdown_item);
                termSpinner.setAdapter(termAdapter);

                areaAdapter = ArrayAdapter.createFromResource(CreateActivity.this, R.array.universityArea, android.R.layout.simple_spinner_dropdown_item);
                areaSpinner.setAdapter(areaAdapter);
            }
        });
    }
}