package com.example.cab2u;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity_DB extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton add_button;
    private ImageView empty_imageview;
    private TextView no_data;
    CustomAdapter_DB customAdapter_db;
    DBManager myDB;
    ArrayList<String> book_id, book_title, book_author, book_pages, book_pages2, book_pages3, book_pages4,
            book_pages5, book_pages6, book_pages7, book_pages8, book_pages9, book_pages10
            ,book_pages11, book_pages12, book_pages13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_db);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        empty_imageview = findViewById(R.id.empty_imageview);
        no_data = findViewById(R.id.no_data);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_DB.this, AddActivity_DB.class);
                startActivity(intent);
            }
        });
        myDB = new DBManager(MainActivity_DB.this);
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();
        book_pages2 = new ArrayList<>();
        book_pages3 = new ArrayList<>();
        book_pages4 = new ArrayList<>();
        book_pages5 = new ArrayList<>();
        book_pages6 = new ArrayList<>();
        book_pages7 = new ArrayList<>();
        book_pages8 = new ArrayList<>();
        book_pages9 = new ArrayList<>();
        book_pages10 = new ArrayList<>();
        book_pages11 = new ArrayList<>();
        book_pages12 = new ArrayList<>();
        book_pages13 = new ArrayList<>();
        //storeDataInArrays();
        storeDataInArrays2();
        customAdapter_db = new CustomAdapter_DB(MainActivity_DB.this,this, book_id, book_title, book_author,
                book_pages, book_pages2,book_pages3, book_pages4, book_pages5, book_pages6, book_pages7,
                book_pages8, book_pages9,book_pages10, book_pages11, book_pages12, book_pages13);
        recyclerView.setAdapter(customAdapter_db);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity_DB.this));
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteAllNumbersFromServer();
                Intent intent = new Intent(MainActivity_DB.this, MainActivity_DB.class);
                startActivity(intent);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.delete_all){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData2();
        if(cursor.getCount() == 0){
            empty_imageview.setVisibility(View.VISIBLE);
            no_data.setVisibility(View.VISIBLE);
        }else{
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
                book_pages2.add(cursor.getString(4));
                book_pages3.add(cursor.getString(5));
                book_pages4.add(cursor.getString(6));
                book_pages5.add(cursor.getString(7));
                book_pages6.add(cursor.getString(8));
                book_pages7.add(cursor.getString(9));
            }
            empty_imageview.setVisibility(View.GONE);
            no_data.setVisibility(View.GONE);
        }
    }
    void storeDataInArrays2(){
        String url = "https://mohammadreza-karimi.ir/api/read_db1.php"; // آدرس PHP

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray dataArray = response.getJSONArray("data");

                        if (dataArray.length() == 0) {
                            empty_imageview.setVisibility(View.VISIBLE);
                            no_data.setVisibility(View.VISIBLE);
                        } else {
                            HashSet<String> seenSerials = new HashSet<>();

                            for (int i = 0; i < dataArray.length(); i++) {
                                JSONObject item = dataArray.getJSONObject(i);
                                String serial = item.getString("serial");
                                if (!seenSerials.contains(serial)) {
                                    seenSerials.add(serial);
                                    book_id.add(item.getString("id"));
                                    book_title.add(item.getString("serial"));
                                    book_author.add(item.getString("max_ospl90"));
                                    book_pages.add(item.getString("hfa_ospl90"));
                                    book_pages2.add(item.getString("fog"));
                                    book_pages3.add(item.getString("ein"));
                                    book_pages4.add(item.getString("current"));
                                    book_pages5.add(item.getString("thd500"));
                                    book_pages6.add(item.getString("thd800"));
                                    book_pages7.add(item.getString("thd1600"));
                                    book_pages8.add(item.getString("f1"));
                                    book_pages9.add(item.getString("f2"));
                                    book_pages10.add(item.getString("temp"));
                                    book_pages11.add(item.getString("humidity"));
                                    book_pages12.add(item.getString("producer"));
                                    book_pages13.add(item.getString("qc_operator"));
                                }
                            }

                            empty_imageview.setVisibility(View.GONE);
                            no_data.setVisibility(View.GONE);
                            customAdapter_db.notifyDataSetChanged();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity_DB.this, "JSON error", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(MainActivity_DB.this, "Connection error", Toast.LENGTH_SHORT).show();
                }
        );

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }
    private void deleteAllNumbersFromServer() {
        String url = "https://mohammadreza-karimi.ir/api/delete_all_numbers_db1.php"; // آدرس فایل PHP

        // اگر خواستی بعداً توکن امنیتی اضافه کنی می‌تونی تو این jsonBody بذاری
        JSONObject jsonBody = new JSONObject();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonBody,  // می‌تونه خالی باشه ولی حتماً JSON باشه چون سرور انتظارش رو داره
                response -> {
                    try {
                        String status = response.getString("status");
                        String message = response.getString("message");

                        if ("ok".equals(status)) {
                            Toast.makeText(this, "همه داده‌ها حذف شدند", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "خطا در حذف داده‌ها: " + message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "خطا در پردازش پاسخ", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(this, "خطای ارتباط با سرور", Toast.LENGTH_SHORT).show();
                }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

}