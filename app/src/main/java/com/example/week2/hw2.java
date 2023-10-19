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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.week2.Employee.Employee;
import com.example.week2.Employee.Official;
import com.example.week2.Employee.SeasonalEmployee;

import java.util.ArrayList;

public class hw2 extends AppCompatActivity {
    String selectedValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2);
        Button button = findViewById(R.id.button);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        EditText inputId = findViewById(R.id.input1);
        EditText inputName = findViewById(R.id.input2);
        ListView lvEmp = findViewById(R.id.listViewEmp);
        ArrayList<Employee> empList = new ArrayList<>();
        ArrayAdapter<Employee> adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, empList);
        lvEmp.setAdapter(adapter);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                selectedValue = radioButton.getText().toString();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputId != null && inputName != null){
                    String id = inputId.getText().toString();
                    String name = inputName.getText().toString();
                    System.out.println(selectedValue);
                    if (selectedValue != ""){
                        Employee emp;
                        if (selectedValue.equals("Official")){
                            emp = new Official(id, name);
                            empList.add(emp);
                        }
                        else if (selectedValue.equals("Seasonal")) {
                            emp = new SeasonalEmployee(id, name);
                            empList.add(emp);
                        }
                    }
                    adapter.notifyDataSetChanged();
                    for (Employee emp : empList){
                        System.out.println(emp);
                    }
                }
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

            }
        });

        lvEmp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                empList.remove(arg2);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

    }
}