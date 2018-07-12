package com.example.galab.authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail, loginPassword;
    private Button loginLoginBtn, loginRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = (EditText) findViewById(R.id.lEmail);
        loginPassword = (EditText) findViewById(R.id.lPassword);

        loginLoginBtn = (Button) findViewById(R.id.lLoginBtn);
        loginRegisterBtn = (Button) findViewById(R.id.lRegisterBtn);


        loginLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(TextUtils.isEmpty(loginEmail.getText().toString().trim()) && TextUtils.isEmpty(loginPassword.getText().toString().trim()))){

                    login(loginEmail.getText().toString().trim(), loginPassword.getText().toString().trim());
                }
            }
        });

    }

    private void login(final String e, final String p) {
        RequestQueue MyRequestQueue = Volley.newRequestQueue(LoginActivity.this);
        String url = "http://yourdomain.com/path";
        StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //This code is executed if the server responds, whether or not the response contains data.
                //The String 'response' contains the server's response.
            }
        }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
            @Override
            public void onErrorResponse(VolleyError error) {
                //This code is executed if there is an error.
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> MyData = new HashMap<String, String>();
                MyData.put("email", e); //Add the data you'd like to send to the server.
                MyData.put("password", p);
                return MyData;
            }
        };
        MyRequestQueue.add(MyStringRequest);
    }




}
