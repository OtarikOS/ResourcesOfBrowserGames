package com.demoexamp.android.loginacttivity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class XCraftAction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_craft_action);
    }

    public void openFile(View view) {

        TextView infotv =findViewById(R.id.info_tv);
        StringBuilder stringBuilder= new StringBuilder();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getApplicationContext().getAssets().open("comet.txt"), "UTF-8"));
   //          do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
 //              process line
                stringBuilder.append(mLine);
            }
                infotv.setText(stringBuilder.toString());

        } catch (IOException e) {
  //          log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
       //             log the exception
                }
            }

        }

    }

}