package com.example.cab2u;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddActivity_DR extends AppCompatActivity {
    private EditText title_input, author_input, pages_input, pages_input2, pages_input3, pages_input4,
            pages_input5, pages_input6, pages_input7, pages_input8, pages_input9, pages_input10,
            pages_input11, pages_input12, pages_input13;
    private Button add_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dr);
        title_input = findViewById(R.id.title_input);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
        pages_input2 = findViewById(R.id.pages_input2);
        pages_input3 = findViewById(R.id.pages_input3);
        pages_input4 = findViewById(R.id.pages_input4);
        pages_input5 = findViewById(R.id.pages_input5);
        pages_input6 = findViewById(R.id.pages_input6);
        pages_input7 = findViewById(R.id.pages_input7);
        pages_input8 = findViewById(R.id.pages_input8);
        pages_input9 = findViewById(R.id.pages_input9);
        pages_input10 = findViewById(R.id.pages_input10);
        pages_input11 = findViewById(R.id.pages_input11);
        pages_input12 = findViewById(R.id.pages_input12);
        pages_input13 = findViewById(R.id.pages_input13);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendNumbersToServer(title_input.getText().toString().trim(),author_input.getText().toString().trim(),pages_input.getText().toString().trim(),
                        pages_input2.getText().toString().trim(),pages_input3.getText().toString().trim(), pages_input4.getText().toString().trim(),
                        pages_input5.getText().toString().trim(),pages_input6.getText().toString().trim(),pages_input7.getText().toString().trim(),
                        pages_input8.getText().toString().trim(),pages_input9.getText().toString().trim(),pages_input10.getText().toString().trim(),
                        pages_input11.getText().toString().trim(),pages_input12.getText().toString().trim(),pages_input13.getText().toString().trim());
            }
        });
    }
    private void sendNumbersToServer(String serial, String max_ospl90, String hfa_ospl90, String fog, String ein, String current,
                                     String thd500, String thd800, String thd1600, String f1, String f2, String temp,String humidity,
                                     String producer, String qc_operator) {
        String url = "https://mohammadreza-karimi.ir/api/insert_numbers_dr1.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("serial", serial);
            jsonBody.put("max_ospl90", max_ospl90);
            jsonBody.put("hfa_ospl90", hfa_ospl90);
            jsonBody.put("fog", fog);
            jsonBody.put("ein", ein);
            jsonBody.put("current", current);
            jsonBody.put("thd500", thd500);
            jsonBody.put("thd800", thd800);
            jsonBody.put("thd1600", thd1600);
            jsonBody.put("f1", f1);
            jsonBody.put("f2", f2);
            jsonBody.put("temp", temp);
            jsonBody.put("humidity", humidity);
            jsonBody.put("producer", producer);
            jsonBody.put("qc_operator", qc_operator);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                response -> {
                    Log.d("SERVER", "Response: " + response.toString());
                    Toast.makeText(this, "Server: " + response.toString(), Toast.LENGTH_LONG).show();
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(this, "Error: " + error.toString(), Toast.LENGTH_LONG).show();
                });

        queue.add(request);
    }
}