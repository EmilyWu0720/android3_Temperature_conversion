package com.example.temperature_conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int clicks = 0;

    public void conversion(View view) {
        EditText editText = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        try {
            float temperature = Float.parseFloat(editText.getText().toString());
            if (!editText.getText().toString().contains("f") && !editText.getText().toString().contains("F")) {
                if (clicks == 0) {
                    textView2.setText("華氏:");
                    textView.setText("°F");
                    temperature = temperature * 9 / 5 + 32;
                    editText.setText("" + (float) (Math.round(temperature * 100)) / 100);
                    clicks = 1;
                } else {
                    textView2.setText("攝氏:");
                    textView.setText("°C");
                    temperature = (temperature - 32) / 9 * 5;
                    editText.setText("" + (float) (Math.round(temperature * 100)) / 100);
                    clicks = 0;
                }
            } else {
                Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "請輸入數字", Toast.LENGTH_LONG).show();
        }
    }
}