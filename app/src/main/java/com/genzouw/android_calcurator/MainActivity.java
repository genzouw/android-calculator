package com.genzouw.android_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.java.dev.eval.Expression;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Map<Integer, String> appendCharsMap = new HashMap<Integer, String>() {
            {
                this.put(R.id.button_0, "0");
                this.put(R.id.button_1, "1");
                this.put(R.id.button_2, "2");
                this.put(R.id.button_3, "3");
                this.put(R.id.button_4, "4");
                this.put(R.id.button_5, "5");
                this.put(R.id.button_6, "6");
                this.put(R.id.button_7, "7");
                this.put(R.id.button_8, "8");
                this.put(R.id.button_9, "9");
                this.put(R.id.button_dot, ".");
                this.put(R.id.button_add, "+");
                this.put(R.id.button_subtract, "-");
                this.put(R.id.button_multiple, "*");
                this.put(R.id.button_devide, "/");
            }
        };

        final EditText displayNumber = this.findViewById(R.id.number_display);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_dot:
                    case R.id.button_add:
                    case R.id.button_subtract:
                    case R.id.button_multiple:
                    case R.id.button_devide:
                        displayNumber.setText(displayNumber.getText().toString().replaceAll("[^0-9]$", ""));
                        break;
                }

                displayNumber.append(appendCharsMap.get(v.getId()));
            }
        };

        for(Integer buttonId : appendCharsMap.keySet()) {
            this.findViewById(buttonId).setOnClickListener(clickListener);
        }

        Button buttonDelete = this.findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber.setText("");
            }
        });

        Button buttonAnswer = this.findViewById(R.id.button_answer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BigDecimal answer =  Expression.eval(displayNumber.getText().toString());
                    displayNumber.setText(answer.toString());
                } catch (Exception e) {
                    displayNumber.setText("");
                }
            }
        });

    }
}
