package com.io.jees.blockchainapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.io.jees.blockchainapp.model.BlockchainData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    public static final String urlSingleBlock = "https://blockchain.info/ko/rawblock/";                        // https://blockchain.info/ko/rawblock/$block_hash
    public static final String urlSingleTransaction = "https://blockchain.info/ko/rawtx/";                     // https://blockchain.info/ko/rawtx/$tx_hash

    private static final int NONE = 0;
    private static final int INPUT = 1;
    private static final int OUTPUT = 2;

    Button.OnClickListener mClickListenerSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get string of hash
            EditText hashText = (EditText) findViewById(R.id.et_hash);
            String hash = hashText.getText().toString();

            hash = "0000000000000bae09a7a393a8acded75aa67e46cb81f7acaa5ad94f9eacd103";
            requestJsonObject(hash);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_search).setOnClickListener(mClickListenerSearch);
    }

    private void requestJsonObject(String hash) {
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = urlSingleBlock + hash;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Log.d(TAG, "Response " + response);

                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();

                BlockchainData bd = new BlockchainData();
                List<BlockchainData> posts = new ArrayList<BlockchainData>();
                posts = Arrays.asList(mGson.fromJson(response, bd.getClass()));

                Log.d(TAG, "size " + posts.get(0).getSize());

                /*
                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
                recyclerView.setAdapter(adapter);
                */
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }
}
