package com.typeandrun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etmake, etyear, etcolor, etprice, etengine;
    private Button btnsave;
    private TextView tvOutput;

    double price, engine;
    String make, color, res;
    int year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmake = findViewById(R.id.etmake);
        etyear = findViewById(R.id.etyear);
        etcolor = findViewById(R.id.etcolor);
        etprice = findViewById(R.id.etprice);
        etengine = findViewById(R.id.etengine);
        btnsave = findViewById(R.id.btnsave);
        tvOutput = findViewById(R.id.tvOutput);


        btnsave.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnsave) {
            if (validation()) {

                make = etmake.getText().toString();
                engine = Double.parseDouble(etengine.getText().toString());
                price = Double.parseDouble(etprice.getText().toString());
                year = Integer.parseInt(etyear.getText().toString());
                color = etcolor.getText().toString();

                TypeandRun obj = new TypeandRun();
                obj.setMake(make);
                obj.setColor(color);
                obj.setYear(year);
                obj.setPrice(price);
                obj.setEngine(engine);

                res = obj.runCmd();
                tvOutput.append(res);






            }
        }
    }



        public boolean validation(){
            boolean flag = true;
            if (TextUtils.isEmpty(etmake.getText().toString())){
                etmake.setError("Please enter Height");
                etmake.requestFocus();
                flag = false;
            }

            else if (TextUtils.isEmpty(etyear.getText().toString())){
                etyear.setError("Please enter Height");
                etyear.requestFocus();
                flag = false;
            }

            else if(TextUtils.isEmpty(etcolor.getText().toString())){
                etcolor.setError("Please enter Height");
                etcolor.requestFocus();
                flag= false;
            }

            else if(TextUtils.isEmpty(etengine.getText().toString())){
                etengine.setError("Please enter Height");
                etengine.requestFocus();
                flag= false;
            }

            else if(TextUtils.isEmpty(etprice.getText().toString())){
                etprice.setError("Please enter Height");
                etprice.requestFocus();
                flag= false;
            }

              return flag;

    }
















}


