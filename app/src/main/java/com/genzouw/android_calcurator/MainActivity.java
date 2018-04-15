package com.genzouw.android_calcurator;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText displayNumber = this.findViewById(R.id.number_display);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                displayNumber.append(clickedButton.getText());
            }
        };

        List<Integer> buttonIds = new ArrayList();
        buttonIds.add(R.id.button_0);
        buttonIds.add(R.id.button_1);
        buttonIds.add(R.id.button_2);
        buttonIds.add(R.id.button_3);
        buttonIds.add(R.id.button_4);
        buttonIds.add(R.id.button_5);
        buttonIds.add(R.id.button_6);
        buttonIds.add(R.id.button_7);
        buttonIds.add(R.id.button_8);
        buttonIds.add(R.id.button_9);
        buttonIds.add(R.id.button_dot);

        for (Integer buttonId : buttonIds) {
            this.findViewById(buttonId).setOnClickListener(clickListener);
        }

        Button buttonDelete = this.findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber.setText("");
            }
        });

        Button buttonAdd = this.findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                displayNumber.append("+");
            }
        });

        Button buttonSubtract = this.findViewById(R.id.button_subtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                displayNumber.append("-");
            }
        });

        Button buttonAnswer = this.findViewById(R.id.button_answer);
        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = (Button) v;
                displayNumber.append(Eval);
            }
        });

    }
}
