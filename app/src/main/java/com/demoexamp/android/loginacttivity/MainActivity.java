package com.demoexamp.android.loginacttivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {



    Map<EditText, EditText> arraymap = new ArrayMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = (EditText) findViewById(R.id.username);
        EditText pass = (EditText) findViewById(R.id.password);
        Button sig = (Button) findViewById(R.id.login);
        Button registration = (Button) findViewById(R.id.registration);
        TextView hint = (TextView) findViewById(R.id.hint_reg);

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = null;
                if (resultLogin() == true) {
                    Intent i = new Intent(MainActivity.this, ChoiceActivity.class);
                    startActivity(i);
                } else
                    hint.setText(getString(R.string.no_registration));
                    try {
                        Toast.makeText(MainActivity.this, "@string/no_registration", Toast.LENGTH_LONG).show();
                        TimeUnit.SECONDS.sleep(5);
                    }
                     catch (InterruptedException e) {
                        e.printStackTrace();
                }
                hint.setText(s);s = "yzrth";
            }


            private boolean resultLogin() {
                //TODO login verification
                if(login.toString().isEmpty()||pass.toString().isEmpty())
                return false;
                else{
                    arraymap.containsKey(login);

                   if((arraymap.get(login).toString()).equals(pass.toString())){
                     return true;
                   }
                   else
                       return false;
                }
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(login.getText().toString().isEmpty())&&!(pass.getText().toString().isEmpty())&&emailValidator(login)){
                    arraymap.put(login,pass);
                }
            }

            private boolean emailValidator(EditText login) {
                //TODO
                String s =login.getText().toString();
                if(Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    Toast.makeText(MainActivity.this, "Email Verified !", Toast.LENGTH_SHORT).show();
                    return true;
                }
        else {
                    Toast.makeText(MainActivity.this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });
    }
}



