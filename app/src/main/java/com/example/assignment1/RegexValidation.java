package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import java.util.Objects;
import java.util.regex.Pattern;

public class RegexValidation extends AppCompatActivity {

    private EditText name,email,phone,id,pass;
    private LinearLayout inputlayout, outputlayout;
    private String nameS, idS, emailS, phoneS, deptS,passwordS;
    private Spinner deptSpinner;
    private Button regexBtn,btnRegexClearOutput;
    private TextView regexOutputTextView;

    private Pattern namePattern = Pattern.compile("[a-zA-Z._ ]+");
    private Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z.]+\\.[a-zA-Z]{2,}$");

    private Pattern phonePattern = Pattern.compile("^01[13-9]\\d{8}$");

    private Pattern idPattern = Pattern.compile("^\\d{16}$");

    private Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$");

//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex_validation);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        id = findViewById(R.id.Id);
        regexBtn = findViewById(R.id.btnRegex);
        deptSpinner = findViewById(R.id.spinner);
        inputlayout = findViewById(R.id.inputLayout);
        outputlayout = findViewById(R.id.outputLayout);
        regexOutputTextView = findViewById(R.id.outputText);
        pass = findViewById(R.id.pass);
        btnRegexClearOutput = findViewById(R.id.btnRegexClearOutput);


        String[] items = new String[]{ "Select Department","CSE", "EEE", "ARCH", "CE", "BuA", "ENG", "LAW", "IS", "BNG", "THM", "PH"};
        deptSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, items));
        deptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deptS = deptSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        regexBtn.setOnClickListener(v -> {

            nameS = name.getText().toString();
            idS = id.getText().toString();
            emailS = email.getText().toString();
            phoneS = phone.getText().toString();
            passwordS = pass.getText().toString();

            if (nameS.isEmpty()) {
                name.setError("Empty!!");
                name.requestFocus();
            } else if (!namePattern.matcher(nameS).matches()) {
                name.setError("Name can only contain alphabets and spaces");
                name.requestFocus();
            } else if (idS.isEmpty()) {
                id.setError("Empty!!");
                id.requestFocus();
            } else if (!idPattern.matcher(idS).matches()) {
                id.setError("ID must be numeric");
                id.requestFocus();
            } else if (emailS.isEmpty()) {
                email.setError("Empty!!");
                email.requestFocus();
            } else if (!emailPattern.matcher(emailS).matches()) {
                email.setError("Invalid email format");
                email.requestFocus();
            } else if (phoneS.isEmpty()) {
                phone.setError("Empty!!");
                phone.requestFocus();
            } else if (!phonePattern.matcher(phoneS).matches()) {
                phone.setError("Invalid Bangladeshi phone number");
                phone.requestFocus();
            } else if (passwordS.isEmpty()) {
                pass.setError("Empty!!");
                pass.requestFocus();
            } else if (!passwordPattern.matcher(passwordS).matches()) {
                pass.setError("Password must contain at least 8 characters, one uppercase, one lowercase, one digit, and one special character");
                pass.requestFocus();
            } else if (Objects.equals(deptS, "Select Department")) {
                Toast.makeText(getApplicationContext(), "Please Select Department", Toast.LENGTH_SHORT).show();
            } else {

                name.setText("");
                id.setText("");
                email.setText("");
                phone.setText("");
                pass.setText("");
                deptSpinner.setSelection(0);


                inputlayout.setVisibility(View.GONE);
                outputlayout.setVisibility(View.VISIBLE);
                String s = "Name: " + nameS + "\nId: " + idS + "\nEmail: " + emailS + "\nMobile Number: " + phoneS + "\nDepartment: " + deptS;
                regexOutputTextView.setText(s);

            }
        });
        btnRegexClearOutput.setOnClickListener(v -> {
            inputlayout.setVisibility(View.VISIBLE);
            outputlayout.setVisibility(View.GONE);
        });
    }
}