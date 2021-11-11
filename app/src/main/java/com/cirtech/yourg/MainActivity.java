package com.cirtech.yourg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Spinner sp1,sp2;
EditText ed1,output;
Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= findViewById(R.id.txtamount);
        sp1= findViewById(R.id.spfrom);
        sp2= findViewById(R.id.spto);
        b1= findViewById(R.id.btn1);
        output= findViewById(R.id.output);

        String [] from = {"USD"};
        ArrayAdapter ad = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String [] to = {"KSH","GBP","Saudi Riyal"};
        ArrayAdapter ad1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter amount in USD",Toast.LENGTH_LONG).show();

                }else{
                Double total=0.0;
                Double amount = Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString()=="USD"&&sp2.getSelectedItem().toString()=="KSH"){
                    total=amount*102.3;
                }else if(sp1.getSelectedItem().toString()=="USD"&&sp2.getSelectedItem().toString()=="GBP"){
                    total= amount*102.3/150.4;
                }else if (sp1.getSelectedItem().toString()=="USD"&&sp2.getSelectedItem().toString()=="Saudi Riyal"){
                    total= amount*102.3/70.54;
                }
                Toast.makeText(getApplicationContext(),total.toString(),Toast.LENGTH_LONG).show();
                output.setText(total.toString());

            }}
        });
    }
}