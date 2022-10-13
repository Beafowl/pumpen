package com.example.pumpen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.inputText);
        output = (TextView) findViewById(R.id.textView);
    }

    protected void updateText(View view) {

        //output.setText("xD");
    }
}