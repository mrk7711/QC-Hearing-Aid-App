package com.example.cab2u;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class UpdateActivity extends AppCompatActivity {

    private EditText title_input, author_input, pages_input, pages_input2, pages_input3, pages_input4, pages_input5, pages_input6, pages_input7,
            pages_input8, pages_input9, pages_input10, pages_input11, pages_input12, pages_input13;
    private Button update_button, delete_button;
    private String id, title, author, pages, pages2, pages3, pages4, pages5, pages6, pages7, pages8, pages9, pages10, pages11, pages12, pages13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        title_input = findViewById(R.id.title_input2);
        author_input = findViewById(R.id.author_input2);
        pages_input = findViewById(R.id.pages_input2);
        pages_input2 = findViewById(R.id.pages_input3);
        pages_input3 = findViewById(R.id.pages_input4);
        pages_input4 = findViewById(R.id.pages_input5);
        pages_input5 = findViewById(R.id.pages_input6);
        pages_input6 = findViewById(R.id.pages_input7);
        pages_input7 = findViewById(R.id.pages_input8);
        pages_input8 = findViewById(R.id.pages_input9);
        pages_input9 = findViewById(R.id.pages_input10);
        pages_input10 = findViewById(R.id.pages_input11);
        pages_input11 = findViewById(R.id.pages_input12);
        pages_input12 = findViewById(R.id.pages_input13);
        pages_input13 = findViewById(R.id.pages_input14);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                DBManager myDB = new DBManager(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                author = author_input.getText().toString().trim();
                pages = pages_input.getText().toString().trim();
                pages2 = pages_input2.getText().toString().trim();
                pages3 = pages_input3.getText().toString().trim();
                pages4 = pages_input4.getText().toString().trim();
                pages5 = pages_input5.getText().toString().trim();
                pages6 = pages_input6.getText().toString().trim();
                pages7 = pages_input7.getText().toString().trim();
                pages8 = pages_input8.getText().toString().trim();
                pages9 = pages_input9.getText().toString().trim();
                pages10 = pages_input10.getText().toString().trim();
                pages11 = pages_input11.getText().toString().trim();
                pages12 = pages_input12.getText().toString().trim();
                pages13 = pages_input13.getText().toString().trim();
                updateDataToServer(id,title,author,pages,pages2,pages3,pages4,pages5,pages6,pages7,pages8,pages9,pages10,pages11,pages12,pages13);
                //myDB.updateData(id, title, author, pages, pages2, pages3, pages4, pages5, pages6, pages7);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
                getIntent().hasExtra("author") && getIntent().hasExtra("pages") && getIntent().hasExtra("pages2")
                && getIntent().hasExtra("pages3")
                && getIntent().hasExtra("pages4")
                && getIntent().hasExtra("pages5")
                && getIntent().hasExtra("pages6")
                && getIntent().hasExtra("pages7")
                && getIntent().hasExtra("pages8")
                && getIntent().hasExtra("pages9")
                && getIntent().hasExtra("pages10")
                && getIntent().hasExtra("pages11")
                && getIntent().hasExtra("pages12")
                && getIntent().hasExtra("pages13")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");
            pages2 = getIntent().getStringExtra("pages2");
            pages3 = getIntent().getStringExtra("pages3");
            pages4 = getIntent().getStringExtra("pages4");
            pages5 = getIntent().getStringExtra("pages5");
            pages6 = getIntent().getStringExtra("pages6");
            pages7 = getIntent().getStringExtra("pages7");
            pages8 = getIntent().getStringExtra("pages8");
            pages9 = getIntent().getStringExtra("pages9");
            pages10 = getIntent().getStringExtra("pages10");
            pages11 = getIntent().getStringExtra("pages11");
            pages12 = getIntent().getStringExtra("pages12");
            pages13 = getIntent().getStringExtra("pages13");

            //Setting Intent Data
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);
            pages_input2.setText(pages2);
            pages_input3.setText(pages3);
            pages_input4.setText(pages4);
            pages_input5.setText(pages5);
            pages_input6.setText(pages6);
            pages_input7.setText(pages7);
            pages_input8.setText(pages8);
            pages_input9.setText(pages9);
            pages_input10.setText(pages10);
            pages_input11.setText(pages11);
            pages_input12.setText(pages12);
            pages_input13.setText(pages13);
            Log.d("stev", title+" "+author+" "+pages);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteRecordFromServer(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
    private void deleteRecordFromServer(String id) {
        String url = "https://mohammadreza-karimi.ir/api/delete_ab.php";
        RequestQueue queue = Volley.newRequestQueue(this);

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("id", id);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "JSON error", Toast.LENGTH_SHORT).show();
            return;
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                response -> {
                    Log.d("SERVER", "Delete Response: " + response.toString());
                    Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(this, "Delete Failed: " + error.toString(), Toast.LENGTH_SHORT).show();
                });

        queue.add(request);
    }
    private void updateDataToServer(String id, String serial, String max_ospl90, String hfa_ospl90,
                                    String fog, String ein, String current,
                                    String thd500, String thd800, String thd1600,
                                    String f1, String f2, String temp, String humidity,
                                    String producer, String qc_operator) {

        String url = "https://mohammadreza-karimi.ir/api/update_ab1.php"; // ← آدرس فایل PHP آپدیت

        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("id", id);
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

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                    response -> {
                        try {
                            String status = response.getString("status");
                            String message = response.getString("message");
                            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "خطا در دریافت پاسخ", Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(), "خطا در اتصال به سرور", Toast.LENGTH_SHORT).show();
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "خطا در ساخت داده‌ها", Toast.LENGTH_SHORT).show();
        }
    }


}
