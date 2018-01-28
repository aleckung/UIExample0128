package com.example.user.uiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DataPickerEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapicker);

        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        final Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth()+1;
                int day = datePicker.getDayOfMonth();
                textView.setText(year + "-" +month+"-" + day);
            }
        });
    }
}
