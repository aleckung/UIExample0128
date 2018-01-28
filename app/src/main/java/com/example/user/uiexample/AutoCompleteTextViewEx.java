package com.example.user.uiexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class AutoCompleteTextViewEx extends AppCompatActivity {

    private static final String[] TAIWAN = new String[]{"Keelung", "Taipei", "Taoyuan", "Hsinchu", "Miaoli", "Taichung", "Changhua", "Nantou", "Yunlin", "Chiayi", "Tainan", "Kaohsiung", "Pingtung ", "Yilan", "Hualien", "Taitung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocompletetextview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, TAIWAN);
        AutoCompleteTextView TaiwanCity = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        TextView tvCities = (TextView) findViewById(R.id.textView2);
        String text = "";
        for (String cityName : TAIWAN)
            text += cityName + "\n";

        System.out.println("text = " + text);
        tvCities.setText(text);
        TaiwanCity.setOnEditorActionListener(listener);
        TaiwanCity.setAdapter(adapter);
    }
    private TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Toast.makeText(AutoCompleteTextViewEx.this, v.getText(), Toast.LENGTH_SHORT).show();
            return true;
        }
    };
}
