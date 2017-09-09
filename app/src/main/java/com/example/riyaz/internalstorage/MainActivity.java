package com.example.riyaz.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText ed1;
    TextView tv;
    Button b1,b2;
    String data;
    public String file = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.ed1);
        tv = (TextView)findViewById(R.id.tv);
        b1 = (Button)findViewById(R.id.load);
        b2 = (Button)findViewById(R.id.read);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            data = ed1.getText().toString();
                try {
                    FileOutputStream fout = openFileOutput(file,MODE_WORLD_READABLE);
                    fout.write(data.getBytes());
                    fout.close();
                    Toast.makeText(MainActivity.this,"File Saved",Toast.LENGTH_LONG).show();
                }
                catch (Exception e){

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp = "";
                    while ((c = fin.read()) != -1) {
                        temp = temp + Character.toString((char) c);
                    }
                    tv.setText(temp);
                    Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            });
    }
}
