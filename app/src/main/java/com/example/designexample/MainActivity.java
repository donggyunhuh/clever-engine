package com.example.designexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    RelativeLayout RelativeLayout_login, RelativeLayout_facebook;
    TextView Textview_signup;
    String emailOk = "0000";
    String passwordOK = "0000";

    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        RelativeLayout_login = findViewById(R.id.RelativeLayout_login);
        RelativeLayout_facebook =findViewById(R.id.RelativeLayout_facebook);
        Textview_signup = findViewById(R.id.TextView_signup);

        //1.값을 가져온다  -  검사 (123@gmail.com / 1234)
        //2. 클릭을 감지한다
        //3. 1번의 값을 다른 액티비티로 넘긴다


        Textview_signup.setClickable(true);
        Textview_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });



      RelativeLayout_facebook.setClickable(true);
      RelativeLayout_facebook.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, Facebooklogin.class);
              startActivity(intent);
          }
      });




      //email 시작
     RelativeLayout_login.setClickable(false);


      TextInputEditText_email.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
              //      Log.d("SENTI", s +"," + count);
              if (s != null) {
                  inputEmail = s.toString();
                  RelativeLayout_login.setClickable(validation());

              }
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });

      // password 시작

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             //   Log.d("SENTI", s +"," + count);
                if(s != null) {
                    inputPassword = s.toString();
                    RelativeLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


       RelativeLayout_login.setOnClickListener(new View.OnClickListener() {
          @Override

          public void onClick(View v) {

             // Log.d("SENTI", "onClick");

              String email = TextInputEditText_email.getText().toString();
              String password = TextInputEditText_password.getText().toString();

              Intent intent = new Intent(MainActivity.this, LoginResult.class);
              intent.putExtra("email",email);
              intent.putExtra("password", password);
              startActivity(intent);
          }

      });



    }

    public boolean validation() {
       // Log.d("SENTI", inputEmail + "/" + inputPassword + "/" + (inputEmail.equals(emailOk)) + "/" + (inputPassword.equals(passwordOK)));
        return inputEmail.equals(emailOk) && inputPassword.equals(passwordOK);
    }
}