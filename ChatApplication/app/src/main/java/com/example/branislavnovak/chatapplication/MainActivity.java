package com.example.branislavnovak.chatapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button bRegister;
    private Button bLogin;
    private EditText usernameTypedText, passwordTypedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final boolean[] usernameEntered = {false};
        final boolean[] passwordEntered = {false};

        // logic for REGISTER button

        bRegister =  findViewById(R.id.registerButton);
        bRegister.setOnClickListener(this);

        // logic for LOGIN button

        bLogin = findViewById(R.id.loginButton);
        bLogin.setOnClickListener(this);
        bLogin.setEnabled(false);

        // logic for enabling

        usernameTypedText = findViewById(R.id.username);
        passwordTypedText = findViewById(R.id.password);

        // checking if username is typed
        usernameTypedText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String lengthCheck = usernameTypedText.getText().toString();
                if (lengthCheck.length() != 0){
                    usernameEntered[0] = true;

                    if (passwordEntered[0]) {
                        bLogin.setEnabled(true);
                    }
                }else{
                    usernameEntered[0] = false;
                    bLogin.setEnabled(false);
                }
            }
        });

        // checking if password is typed
        passwordTypedText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String lengthCheck = passwordTypedText.getText().toString();
                if(lengthCheck.length() >= 6){
                    passwordEntered[0] = true;
                    if(usernameEntered[0]){
                        bLogin.setEnabled(true);
                    }
                }else {
                    passwordEntered[0] = false;
                    bLogin.setEnabled(false);
                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.registerButton:
                Intent i1 = new Intent(this, RegisterActivity.class);
                startActivity(i1);
                break;

            case R.id.loginButton:
                Intent i2 = new Intent(this, ContactsActivity.class);
                startActivity(i2);
                break;
        }
    }
}
