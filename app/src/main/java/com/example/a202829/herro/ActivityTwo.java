package com.example.a202829.herro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityTwo extends ActionBarActivity {

    TextView textToChange;
    EditText changingText;
    Button activityChanger;
    Button listActivityChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        textToChange = (TextView) findViewById(R.id.newText);
        changingText = (EditText) findViewById(R.id.textEditing);
        activityChanger = (Button) findViewById(R.id.backActivityButton);
        listActivityChanger = (Button) findViewById(R.id.listActivityButton);

        activityChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                String textHere = textToChange.getText().toString();
                intent.putExtra("changedText",textHere);
                setResult(RESULT_OK,intent);
                finish();//finishing activity

            }
        });

        listActivityChanger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityTwo.this, ListActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        changingText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        textToChange.setText(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                }


        );


    }


}
