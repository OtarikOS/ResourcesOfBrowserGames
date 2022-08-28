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
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_craft_action);
    }


    public void openFile(View view) {
        String fileName = "";

        switch (view.getId()) {
            case R.id.button_comet:
                fileName = "comet.txt";
                break;
            case R.id.button_planet:
                fileName = "planet.txt";
                break;
            case R.id.button_list:
                count++;
                if (count % 2 == 0) {
                    findViewById(R.id.button_comet).setVisibility(View.VISIBLE);
                    findViewById(R.id.button_planet).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.button_comet).setVisibility(View.GONE);
                    findViewById(R.id.button_planet).setVisibility(View.GONE);
                }
                break;
        }


        TextView infotv = findViewById(R.id.info_tv);
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getApplicationContext().getAssets().open(fileName), "UTF-8"));
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