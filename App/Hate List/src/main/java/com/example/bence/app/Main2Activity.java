package com.example.bence.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    Double BMI;
    ArrayList<String> alclist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void saveClick(View v) {
        EditText heightEdit = (EditText) findViewById(R.id.height);
        EditText weightEdit = (EditText) findViewById(R.id.weight);
        Double height = Double.parseDouble(heightEdit.getText().toString());
        Double weight = Double.parseDouble(weightEdit.getText().toString());
        BMI = weight / ((height / 100) * (height / 100));
        heightEdit.setEnabled(false);
        weightEdit.setEnabled(false);
    }


    public void addClick(View v) {
        EditText amountEdit = (EditText) findViewById(R.id.amount);
        EditText alcEdit = (EditText) findViewById(R.id.apercent);
        String item = amountEdit.getText().toString() + "- " + alcEdit.getText().toString();
        alclist.add(item);
        amountEdit.setText("");
        alcEdit.setText("");
        setList();
        setImage();
    }

    public void setList() {
        TextView textList = (TextView) findViewById(R.id.list);
        textList.setText("");
        for (int i = alclist.size() - 1; i >= 0; i--) {
            textList.append(alclist.get(i) + "\n");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
