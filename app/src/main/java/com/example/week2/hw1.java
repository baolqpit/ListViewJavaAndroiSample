package com.example.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class hw1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        TextView textViewShow = findViewById(R.id.textView1);
        Button buttonImport = findViewById(R.id.button2);
        EditText editText = findViewById(R.id.editTextInput);
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("Teo");
        arrList.add("Ty");
        arrList.add("Bin");
        arrList.add("Bo");

//        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arrList);
        lvPerson.setAdapter(adapter);

        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                textViewShow.setText("position :" + arg2 + "; value = " + arrList.get(arg2));
            }
        });



        buttonImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.isEmpty()) {
                    arrList.add(text);
                    adapter.notifyDataSetChanged();
                    editText.setText("");

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        });


    }
}