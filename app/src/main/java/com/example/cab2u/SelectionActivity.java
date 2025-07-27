package com.example.cab2u;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    CustomAdapter_Detail customAdapter;
    ArrayList<String> book_id, book_title, book_author, book_pages, book_pages2, book_pages3, book_pages4,
            book_pages5, book_pages6, book_pages7, book_pages8, book_pages9, book_pages10
            ,book_pages11, book_pages12, book_pages13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        recyclerView = findViewById(R.id.recyclerView);
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
        customAdapter = new CustomAdapter_Detail(SelectionActivity.this,this, book_id, book_title, book_author,
                book_pages, book_pages2,book_pages3, book_pages4, book_pages5, book_pages6, book_pages7,
                book_pages8, book_pages9,book_pages10, book_pages11, book_pages12, book_pages13);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SelectionActivity.this));
        String serial = getIntent().getStringExtra("title");
        loadFilteredData(serial);
    }
    void loadFilteredData(String serial) {
        String url = "https://mohammadreza-karimi.ir/api/read_ab.php";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray dataArray = response.getJSONArray("data");

                        for (int i = 0; i < dataArray.length(); i++) {
                            JSONObject item = dataArray.getJSONObject(i);
                            if (item.getString("serial").equals(serial)) {
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

                        customAdapter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> error.printStackTrace()
        );

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

}