package com.example.yashi.e_attendanceregister.activity;

/**
 * Created by yashi on 13-11-2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yashi.e_attendanceregister.R;

public class NoteCreateActivity extends AppCompatActivity {
    EditText title, body;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        Button btn = (Button) findViewById(R.id.noteSaveButton);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        spinner = (Spinner) findViewById(R.id.pinSpinner);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, MainActivity.divisions);
        assert spinner != null;
        spinner.setAdapter(adapterSpinner);
    }

    private void saveData() {
        title = (EditText) findViewById(R.id.noteTitle);
        body = (EditText) findViewById(R.id.noteBody);

        String title1 = title.getText().toString();
        String body1 = title.getText().toString();
        String sub1 = title.getText().toString();

        if (title1.trim().length() == 0 && body1.trim().length() == 0 && sub1.length() == 0) {
            Toast.makeText(this, "Insufficient data", Toast.LENGTH_SHORT).show();
        } else {

            String qu = " INSERT INTO NOTES(title,body,cls,sub) VALUES('" + title.getText().toString() + "','" + body.getText().toString() + "'," +
                    "'" + spinner.getSelectedItem().toString() + "','" + "NO_SUBJECT" + "')";

            if (MainActivity.handler.execAction(qu)) {
                Toast.makeText(getBaseContext(), "Note Saved", Toast.LENGTH_LONG).show();
                this.finish();
            }
        }
    }

}
