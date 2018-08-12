package com.example.yashi.e_attendanceregister.activity;

/**
 * Created by yashi on 13-11-2017.
 */

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yashi.e_attendanceregister.R;
import com.example.yashi.e_attendanceregister.adapter.ListAdapter;

import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    Button btn, btnx;

    ListView listView;
    ListAdapter adapter;
    ArrayAdapter<String> adapterSpinner;
    ArrayList<String> names;
    ArrayList<String> registers;
    Activity thisActivity = this;
    Spinner spinner;
    public static String time, period;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        time = getIntent().getStringExtra("DATE");
        period = getIntent().getStringExtra("PERIOD");

        Log.d("Attendance", time + " -- " + period);
        listView = (ListView) findViewById(R.id.attendanceListViwe);
        names = new ArrayList<>();
        registers = new ArrayList<>();

        btn = (Button) findViewById(R.id.loadButton);
        btnx = (Button) findViewById(R.id.buttonSaveAttendance);
        btnx.setEnabled(false);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListView(v);
                btnx.setEnabled(true);
            }
        });


        assert btnx != null;
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn == null) {
                    throw new AssertionError("Object cannot be null");
                } else {
                    Toast.makeText(getBaseContext(), "Saving", Toast.LENGTH_SHORT).show();
                    adapter.saveAll();
                }
            }
        });

        spinner = (Spinner) findViewById(R.id.attendanceSpinner);
        adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);

    }

    public void loadListView(View view) {
        names.clear();
        registers.clear();
        String qu = "SELECT * FROM STUDENT WHERE cl = '" + spinner.getSelectedItem().toString() + "' " +
                "ORDER BY ROLL";
        Cursor cursor = MainActivity.handler.execQuery(qu);
        if (cursor == null || cursor.getCount() == 0) {

        } else {
            int ctr = 0;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                names.add(cursor.getString(0) + " (" + cursor.getInt(4) + ')');
                registers.add(cursor.getString(2));
                cursor.moveToNext();
                ctr++;
            }
            if (ctr == 0) {
                Toast.makeText(getBaseContext(), "No Students Found", Toast.LENGTH_LONG).show();
            }
            Log.d("Attendance", "Got " + ctr + " students");
        }
//        String qn = "SELECT * FROM NOTES WHERE cl = '" + spinner.getSelectedItem().toString() + "'";
//        String title = "";
//        String note = "";
//        Cursor cursor1 = AppBase.handler.execQuery(qn);
//        cursor1.moveToFirst();
//        while (!cursor1.isAfterLast())
//        {
//            title+= cursor1.getString(0) + "\n";
//            note+= cursor1.getString(1) + "\n";
//        }
//
//        // display notification
//        Log.d("notify","place the notification here" + title + "and" + note);


        adapter = new ListAdapter(thisActivity, names, registers);
        listView.setAdapter(adapter);
    }
}
