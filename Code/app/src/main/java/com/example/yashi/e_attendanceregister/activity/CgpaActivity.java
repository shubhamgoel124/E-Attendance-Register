package com.example.yashi.e_attendanceregister.activity;

/**
 * Created by yashi on 13-11-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yashi.e_attendanceregister.R;


public class CgpaActivity extends AppCompatActivity {

    EditText s1, s2, s3, s4, s5, s6, s7, s8;
    EditText c1, c2, c3, c4, c5, c6, c7, c8;
    float sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8, cg;
    float cr1, cr2, cr3, cr4, cr5, cr6, cr7, cr8;
    Button btn_cgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
        s1 = (EditText) findViewById(R.id.sgpa1);
        s2 = (EditText) findViewById(R.id.sgpa2);
        s3 = (EditText) findViewById(R.id.sgpa3);
        s4 = (EditText) findViewById(R.id.sgpa4);
        s5 = (EditText) findViewById(R.id.sgpa5);
        s6 = (EditText) findViewById(R.id.sgpa6);
        s7 = (EditText) findViewById(R.id.sgpa7);
        s8 = (EditText) findViewById(R.id.sgpa8);
        c1 = (EditText) findViewById(R.id.credit1);
        c2 = (EditText) findViewById(R.id.credit2);
        c3 = (EditText) findViewById(R.id.credit3);
        c4 = (EditText) findViewById(R.id.credit4);
        c5 = (EditText) findViewById(R.id.credit5);
        c6 = (EditText) findViewById(R.id.credit6);
        c7 = (EditText) findViewById(R.id.credit7);
        c8 = (EditText) findViewById(R.id.credit8);
        btn_cgpa = (Button) findViewById(R.id.btn_cgpa);
        //TextView t=(TextView)findViewById(R.id.tv);
        //t.setVisibility(View.INVISIBLE);


        btn_cgpa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sg1 = read(s1);
                sg2 = read(s2);
                sg3 = read(s3);
                sg4 = read(s4);
                sg5 = read(s5);
                sg6 = read(s6);
                sg7 = read(s7);
                sg8 = read(s8);
                cr1 = read(c1);
                cr2 = read(c2);
                cr3 = read(c3);
                cr4 = read(c4);
                cr5 = read(c5);
                cr6 = read(c6);
                cr7 = read(c7);
                cr8 = read(c8);

                if (sg1 == 0)
                    cr1 = 0;

                if (sg2 == 0)
                    cr2 = 0;

                if (sg3 == 0)
                    cr3 = 0;

                if (sg4 == 0)
                    cr4 = 0;

                if (sg5 == 0)
                    cr5 = 0;

                if (sg6 == 0)
                    cr6 = 0;

                if (sg7 == 0)
                    cr7 = 0;

                if (sg8 == 0)
                    cr8 = 0;


                cg = ((sg1 * cr1) + (sg2 * cr2) + (sg3 * cr3) + (sg4 * cr4) + (sg5 * cr5) + (sg6 * cr6) + (sg7 * cr7) + (sg8 * cr8)) / (cr1 + cr2 + cr3 + cr4 + cr5 + cr6 + cr7 + cr8);
                if (sg1 == 0 && sg2 == 0 && sg3 == 0 && sg4 == 0 && sg5 == 0 && sg6 == 0 && sg7 == 0 && sg8 == 0)
                    Toast.makeText(getApplicationContext(), "Insufficient Data ", Toast.LENGTH_LONG).show();

                else if ((sg1 > 10.0) || sg2 > 10.0 || sg3 > 10.0 || sg4 > 10.0 || sg5 > 10.0 || sg6 > 10.0 || sg7 > 10.0 || sg8 > 10.0) {
                    Toast.makeText(getApplicationContext(), " Invalid SGPA", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i3 = new Intent(getApplicationContext(), ResultActivity.class);
                    i3.putExtra("final_sgpa", cg);
                    i3.putExtra("flag", 0);
                    i3.putExtra("final_perc", 0);
                    startActivity(i3);

                }


                // TODO Auto-generated method stub

            }


        });

    }


    private float read(EditText c) {

        if (c.getText().toString().matches("")) {
            return 0;

        } else {
            return (Float.valueOf(c.getText().toString()).floatValue());
        }

        // TODO Auto-generated method stub
    }

}
